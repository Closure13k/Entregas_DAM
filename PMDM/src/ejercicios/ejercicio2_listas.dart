import 'package:flutter/material.dart';

final datosExercicio2 = <Map<String, dynamic>>[
  {'texto': 'Imagen 1', 'url': 'https://picsum.photos/100/100'},
  {'texto': 'Imagen 2', 'url': 'https://picsum.photos/100/101'},
  {'texto': 'Imagen 3', 'url': 'https://picsum.photos/100/102'},
  {'texto': 'Imagen 4', 'url': 'https://picsum.photos/100/103'},
  {'texto': 'Imagen 1', 'url': 'https://picsum.photos/100/100'},
  {'texto': 'Imagen 2', 'url': 'https://picsum.photos/100/101'},
  {'texto': 'Imagen 3', 'url': 'https://picsum.photos/100/102'},
  {'texto': 'Imagen 4', 'url': 'https://picsum.photos/100/103'},
  {'texto': 'Imagen 1', 'url': 'https://picsum.photos/100/100'},
  {'texto': 'Imagen 2', 'url': 'https://picsum.photos/100/101'},
  {'texto': 'Imagen 3', 'url': 'https://picsum.photos/100/102'},
  {'texto': 'Imagen 4', 'url': 'https://picsum.photos/100/103'},
  {'texto': 'Imagen 1', 'url': 'https://picsum.photos/100/100'},
  {'texto': 'Imagen 2', 'url': 'https://picsum.photos/100/101'},
  {'texto': 'Imagen 3', 'url': 'https://picsum.photos/100/102'},
  {'texto': 'Imagen 4', 'url': 'https://picsum.photos/100/103'},
];

class Ejercicio2Listas extends StatelessWidget {
  const Ejercicio2Listas({Key? key, required this.datos}) : super(key: key);
  final List<Map<String, dynamic>> datos;

  @override
  Widget build(BuildContext context) {
    return ListView(
        children: datos
            .map((e) => Padding(
                  padding: EdgeInsets.all(8),
                  child: Row(children: [
                    Text('${e['texto']}'),
                    FadeInImage.assetNetwork(
                        placeholder:
                            "assets/images/mr_incredible_becoming_uncanny.jpeg",
                        image: e['url'])
                  ]),
                ))
            .toList());
  }
}
/**
 * Crea un StatelessWidget que devolva unha lista no que cada elemento da lista
 * está formado por un texto e unha imaxe, no que se apliquen os datos definidos na constante anterior.
 * Para crear o conxunto de Widget que conforman cada elemento da lista, podes empregar o Widget Row.
 * Fai que a imaxe se cargue dentro dun FadeInImage (podes empregar o constructor
 * FadeInImage.assetNetwork para non ten que empregar providers)
 * Fai que estean separados os elementos da lista, empregando o Widget Padding (terás que envolver o Widget Row con el).
 */
