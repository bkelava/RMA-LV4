package hr.ferit.bozidarkelava.birds

import android.graphics.Color
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BirdsViewModel : ViewModel() {

    var counter = MutableLiveData<Int>() //live data https://youtu.be/1Tn7TuHUl4Y?t=254
    var backgroundColor = MutableLiveData<Int>() //live data

    fun increment() {
        if (this.counter.value == null)
            this.counter.value = 0
        var number  = this.counter.value;
        if (number != null)
            counter.value = number + 1;
    }

    fun setColor(color: Int) {
        this.backgroundColor.value = color
    }

    fun initianteCounter() {
        if (this.counter.value == null) {
            this.counter.value = 0
            setColor(Color.BLACK)
        }
    }
}