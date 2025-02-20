package com.montaury.pokebagarre.metier;

import com.montaury.pokebagarre.fixtures.ConstructeurDePokemon;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//------------------------------------------------Test pour le pokémon 1------------------------------------------------
//---------------------------------------------------------Test 1-------------------------------------------------------
//Given :
//Le pokémon 1 a plus d’attaque que le pokémon 2
//When :
//Le pokémon 1 est plus fort
//Then :
//Le pokémon 1 gagne

//---------------------------------------------------------Test 2-------------------------------------------------------
//Given :
//Le pokémon 1 et 2 ont autant d’attaque l’un que l’autre et que le pokémon 1 a plus de défense que le pokémon 2
//When :
//Le pokémon 1 est plus fort
//Then :
//Le pokémon 1 gagne

//---------------------------------------------------------Test 3-------------------------------------------------------
//Given :
//Le pokémon 1 et 2 ont autant d’attaque et de défense l’un que l’autre
//When :
//Les deux pokémons ont une puissance égale
//Then :
//Le pokémon 1 gagne dans tous les cas

//------------------------------------------------Test pour le pokémon 2------------------------------------------------
//---------------------------------------------------------Test 4-------------------------------------------------------
//Given :
//Le pokémon 2 a plus d’attaque que le pokémon 1
//When :
//Le pokémon 2 est plus fort
//Then :
//Le pokémon 2 gagne

//---------------------------------------------------------Test 5-------------------------------------------------------
//Given :
//Le pokémon 1 et 2 ont autant d’attaque l’un que l’autre et que le pokémon 2 a plus de défense que le pokémon 1
//When :
//Le pokémon 2 est plus fort
//Then :
//Le pokémon 2 gagne

//---------------------------------------------------------Test 6-------------------------------------------------------
//Given :
//Le pokémon 1 et 2 ont autant d’attaque et de défense l’un que l’autre
//When :
//Les deux pokémons ont une puissance égale
//Then :
//Le pokémon 2 ne gagne jamais

class PokemonTest {

    @Test
    void pokemon1_gagne_car_meilleure_attaque_que_pokemon2(){
        // GIVEN
        Pokemon pokemon1 = new ConstructeurDePokemon().avecAttaque(65).construire();
        Pokemon pokemon2 = new ConstructeurDePokemon().avecAttaque(48).construire();
        // WHEN
        boolean resultat = pokemon1.estVainqueurContre(pokemon2);
        // THEN
        assertThat(resultat).isTrue();
    }

    @Test
    void pokemon1_gagne_car_meilleure_defense_que_pokemon2(){
        // GIVEN
        Pokemon pokemon1 = new ConstructeurDePokemon().avecAttaque(65).avecDefense(60).construire();
        Pokemon pokemon2 = new ConstructeurDePokemon().avecAttaque(65).avecDefense(56).construire();
        // WHEN
        boolean resultat = pokemon1.estVainqueurContre(pokemon2);
        // THEN
        assertThat(resultat).isTrue();
    }

    @Test
    void pokemon1_gagne_car_prioritaire_par_rapport_pokemon2(){
        // GIVEN
        Pokemon pokemon1 = new ConstructeurDePokemon().avecAttaque(65).avecDefense(60).construire();
        Pokemon pokemon2 = new ConstructeurDePokemon().avecAttaque(65).avecDefense(60).construire();
        // WHEN
        boolean resultat = pokemon1.estVainqueurContre(pokemon2);
        // THEN
        assertThat(resultat).isTrue();
    }

    @Test
    void pokemon1_perd_car_pokemon2_a_meilleur_attaque(){
        // GIVEN
        Pokemon pokemon1 = new ConstructeurDePokemon().avecAttaque(60).construire();
        Pokemon pokemon2 = new ConstructeurDePokemon().avecAttaque(65).construire();
        // WHEN
        boolean resultat = pokemon1.estVainqueurContre(pokemon2);
        // THEN
        assertThat(resultat).isFalse();
    }

    @Test
    void pokemon1_perd_car_pokemon2_a_meilleur_defense(){
        // GIVEN
        Pokemon pokemon1 = new ConstructeurDePokemon().avecAttaque(60).avecDefense(85).construire();
        Pokemon pokemon2 = new ConstructeurDePokemon().avecAttaque(65).avecDefense(105).construire();
        // WHEN
        boolean resultat = pokemon1.estVainqueurContre(pokemon2);
        // THEN
        assertThat(resultat).isFalse();
    }

    @Test
    void pokemon2_perd_car_pokemon1_prioritaire(){
        // GIVEN
        Pokemon pokemon1 = new ConstructeurDePokemon().avecAttaque(65).avecDefense(105).construire();
        Pokemon pokemon2 = new ConstructeurDePokemon().avecAttaque(65).avecDefense(105).construire();
        // WHEN
        boolean resultat = pokemon1.estVainqueurContre(pokemon2);
        // THEN
        assertThat(resultat).isTrue();
    }
}
