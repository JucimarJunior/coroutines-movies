package com.example.filmescorountines.ui.main

class MainRepository {

    // Função retorna um lista de filmes usando callback
    fun getFilmes(callback: (filmes: List<Filme>) -> Unit) {

        // Simulando uma chamada assíncrona utilizando uma thread do Java
        Thread(Runnable {
            Thread.sleep(3000)
            callback.invoke(
                listOf(
                    Filme(1, "Titulo 1"),
                    Filme(1, "Titulo 2")
                )
            )
        }).start()
    }
}