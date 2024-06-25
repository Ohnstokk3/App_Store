
<img src="https://github.com/Ohnstokk3/App_Store/blob/master/Screenshot_20240620_211435_Main_App_Store.jpg" width="200" height="400" />
<img src="https://github.com/Ohnstokk3/App_Store/blob/master/Screenshot_20240620_212346_Main_App_Store.jpg" width="200" height="400" />
<img src="https://github.com/Ohnstokk3/App_Store/blob/master/Screenshot_20240620_212402_Main_App_Store.jpg" width="200" height="400" />
class MainViewModel : ViewModel() {

    private val _numberList = MutableLiveData<NumberList>(NumberList())
    val numberList: LiveData<NumberList> = _numberList

    fun addNumber(number: String) {
        if (number.isNotEmpty()) {
            _numberList.value?.numbers?.add(number.toDouble())
            _numberList.postValue(_numberList.value) // Update LiveData with new list
        }
    }

    fun multiplyList(multiplier: Double): Double {
        val currentList = _numberList.value?.numbers ?: return 0.0
        var product = 1.0
        for (num in currentList) {
            product *= num
        }
        return product * multiplier
    }
}
