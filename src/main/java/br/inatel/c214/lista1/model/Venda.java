package br.inatel.c214.lista1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venda {
    enum Publisher{
        ACTIVISION("Activision"), ATARI("Atari"), BETHESDA("Bethesda"), SOFTWORKS("Softworks"),
        ELECTRONIC_ARTS("Eletronic Arts"), MICROSOFT_GAME_STUDIOS("Microsoft Game Studios"), NINTENDO("Nintendo"),
        SEGA("Sega"), SONY_COMPUTER_ENTERTAINMENT("Sony Computer Entertainment"), SQUARESOFT("Square Soft"), TAKE_TWO_INTERACTIVE("Take-Two Interactive");
        private String valor;
        Publisher(String valor){
            this.valor = valor;
        }
    }

    enum Platform{
        P3DS("3DS"), DS("DS"), GB("GB"), GBA("GBA"), N64("N64"), NES("NES"), PC("PC"), PS("PS"), PS2("PS2"), PS3("PS3"),
        PS4("PS4"), PSP("PSP"), SNES("SNES"), WII("WII"), X360("X360"), XB("XB");

        private String valor;
        Platform(String valor){
            this.valor = valor;
        }
    }

    private int rank;
    private String name;
    private String Platform;
    private int year;
    private String genre;
    private String publisher;
    private float na_sales;
    private float eu_sales;
    private float jp_sales;
    private float other_sales;
    private float global_sales;
}
