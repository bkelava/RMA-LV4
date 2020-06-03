package hr.ferit.bozidarkelava.birds

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import hr.ferit.bozidarkelava.birds.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: BirdsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(BirdsViewModel::class.java)

        viewModel.initianteCounter()

        setUpUI()
        viewModel.counter.observe(this, androidx.lifecycle.Observer { binding.invalidateAll() })
        viewModel.backgroundColor.observe(this, androidx.lifecycle.Observer { binding.invalidateAll() })
    }
    private fun setUpUI() {
        binding.apply {
            binding.bird=viewModel
            if (viewModel.backgroundColor.value == null) {
                viewModel.backgroundColor.value == Color.BLACK
            }
            binding.btnFirstColor.setOnClickListener() {
                setStats(Color.GREEN)
            }
            binding.btnSecondColor.setOnClickListener() {
                setStats(Color.BLUE)
            }
            binding.btnThirdColor.setOnClickListener() {
                setStats(Color.RED)
            }
            binding.btnFourthColor.setOnClickListener() {
                setStats(Color.YELLOW)
            }
            binding.btnRestart.setOnClickListener() {
                reset()
            }
        }
    }

    private fun setStats (color: Int) {
        viewModel.increment()
        viewModel.setColor(color)
    }

    private fun reset()
    {
        viewModel.counter.value=0;
        viewModel.setColor(Color.BLACK)
    }
}
