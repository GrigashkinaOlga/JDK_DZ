package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Random;

@Getter
@Setter
public class MontyHallSimulation {
    private int wins;
    private int losses;

    public static void main(String[] args) {
        MontyHallSimulation simulation = new MontyHallSimulation();
        int rounds = 1000;
        HashMap<String, String> results = new HashMap<>();

        // Симуляция с переключением выбора
        simulation.simulate(rounds, true);
        results.put("С переключением выбора", "Победы = " + simulation.getWins() + ", Поражения = " + simulation.getLosses());

        // Сброс результатов
        simulation.setWins(0);
        simulation.setLosses(0);

        // Симуляция без переключения выбора
        simulation.simulate(rounds, false);
        results.put("Без переключения выбора", "Победы = " + simulation.getWins() + ", Поражения = " + simulation.getLosses());

        // Вывод результатов
        results.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    public void simulate(int rounds, boolean switchChoice) {
        Random random = new Random();
        for (int i = 0; i < rounds; i++) {
            int carDoor = random.nextInt(3);
            int playerChoice = random.nextInt(3);

            int hostDoor;
            do {
                hostDoor = random.nextInt(3);
            } while (hostDoor == carDoor || hostDoor == playerChoice);

            if (switchChoice) {
                playerChoice = 3 - playerChoice - hostDoor; // Меняем выбор
            }

            if (playerChoice == carDoor) {
                wins++;
            } else {
                losses++;
            }
        }
    }
}

