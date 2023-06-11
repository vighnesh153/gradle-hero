tasks.register("print") {
    doLast {
        // ./gradlew print -PpokemonName=Pikachu
        val pokemonName = project.findProperty("pokemonName") ?: "Charizard"
        println(pokemonName)
    }
}