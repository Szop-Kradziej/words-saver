package io.github.szop_kradziej.wordssaver

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Test

class TranslateServiceTest {

    val translateServiceApi = mock<TranslateServiceApi>()
    val savedWordListViewController = mock<SavedWordListViewController>()

    val translateService = TranslateService(translateServiceApi, savedWordListViewController)

    @Test
    fun shouldSendWordToTranslateService() {
        val WORD_VALUE = "word"

        translateService.translateWord(WORD_VALUE)

        verify(translateServiceApi).translateWord(Word(WORD_VALUE))
    }

    @Test
    fun shouldShowSavedWordsList() {
        val SAVED_WORD = SavedWord("word", "translation")
        val savedWordsList = listOf(SAVED_WORD)
        whenever(translateServiceApi.getSavedWords()).thenReturn(savedWordsList)

        translateService.showSavedWordList()

        verify(translateServiceApi).getSavedWords()
        verify(savedWordListViewController).showSavedWordList(savedWordsList)
    }
}

