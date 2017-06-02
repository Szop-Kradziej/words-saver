package io.github.szop_kradziej.wordssaver

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Test

class TranslateServiceTest {

    val translateServiceApi = mock<TranslateServiceApi>()
    val translateService = TranslateService(translateServiceApi)

    @Test
    fun shouldSendWordToTranslateService() {
        val WORD_VALUE = "word"
        
        translateService.translateWord(WORD_VALUE)

        verify(translateServiceApi).translateWord(Word("word"))
    }
}

class TranslateService(private val translateServiceApi: TranslateServiceApi) {

    fun translateWord(value: String) {
        translateServiceApi.translateWord(Word(value))
    }
}

data class Word(val value: String)

interface TranslateServiceApi {

    fun translateWord(word : Word)
}
