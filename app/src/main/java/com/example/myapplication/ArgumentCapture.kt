package com.example.myapplication

class ArgumentCapture(private val argumentService: ArgumentService) {
    companion object {
      private  const val DATA = "DATA"
    }

    fun getData() {
        val testCallBack = object : Callback {
            override fun onResponse(content: String) {
                when (content) {
                    "dog" -> dog()
                    "cat" -> cat()
                }
            }
        }

        testCallBack.apply { println("getData $this") }

        argumentService.fetchData(testCallBack)
    }

    fun dog() {
        println("dog")
    }

    fun cat() {
        println("cat")
    }

    // dog --> dog()
    // cat --> cat()
}
