package io.github.szop_kradziej.wordssaver

class TranslateService(private val translateServiceApi: TranslateServiceApi, private val savedWordListViewController: SavedWordListViewController) {

    fun translateWord(value: String) {
        translateServiceApi.translateWord(Word(value))
    }

    fun showSavedWordList() {
        val savedWords = translateServiceApi.getSavedWords()
        savedWordListViewController.showSavedWordList(savedWords)
    }
}