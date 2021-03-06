package io.github.szop_kradziej.wordssaver

interface TranslateServiceApi {

    fun translateWord(word : Word)

    fun getSavedWords() : List<SavedWord>
}