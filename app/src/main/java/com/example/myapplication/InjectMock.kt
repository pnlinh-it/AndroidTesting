package com.example.myapplication

class InjectMock {
    companion object{
        private lateinit var s : String
    }
    lateinit var wordMap: MutableMap<String, String>

    fun MyDictionary() {
        wordMap = HashMap()
    }

    fun add(word: String, meaning: String) {
        val a = 1

        wordMap[word] = meaning
    }

    fun getMeaning(word: String): String? {
        return wordMap[word]
    }
}
