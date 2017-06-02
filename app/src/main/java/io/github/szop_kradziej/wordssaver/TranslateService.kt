package io.github.szop_kradziej.wordssaver

class TranslateService(private val translateServiceApi: TranslateServiceApi) {

    fun translateWord(value: String) {
        translateServiceApi.translateWord(Word(value))
    }
}