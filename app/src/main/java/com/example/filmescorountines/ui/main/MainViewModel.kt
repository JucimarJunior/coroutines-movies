package com.example.filmescorountines.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/* Boa prática: Receber o repositório construído via injeção de dependência através de um construtor */
class MainViewModel(private val repository: MainRepository) : ViewModel() {

    /*val repository = MainRepository --> Prática ruim de código*/

    val filmesLiveData = MutableLiveData<List<Filme>>()

    /* Função "getFilmes" que após obter a lista de filmes
    *  vai acionar um liveData do arquiteto de components para quem tiver escuta para poder mostar
    *  a lista de filmes
    * */
    fun getFilmes() {
        repository.getFilmes { filmes ->

            /* Value -> Entrega o resultado na thread em que ele veio
            *  postValue -> Entrega o resultado na thread principal do android
            * */
            filmesLiveData.postValue(filmes)
            /* A partir daqui é possível escutar esses dados em algum Fragment e mostrar essa lista
             * de filmes em algum component
             * */
        }
    }

    class MainViewModelFactory(
        private val repository: MainRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(repository) as T
        }
    }
}