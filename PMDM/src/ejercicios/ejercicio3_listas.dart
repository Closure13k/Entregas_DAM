import 'package:flutter/material.dart';

final datosExercicio3 = <Map<String, dynamic>>[
  {
    'title': 'Imagen 1',
    'subtitle': 'Aclaración imagen1',
    'leading': 'https://picsum.photos/100/100'
  },
  {
    'title': 'Imagen 2',
    'subtitle': 'Aclaración imagen2',
    'leading': 'https://picsum.photos/100/100'
  },
  {
    'title': 'Imagen 3',
    'subtitle': 'Aclaración imagen3',
    'leading': 'https://picsum.photos/100/100'
  },
  {
    'title': 'Imagen 4',
    'subtitle': 'Aclaración imagen4',
    'leading': 'https://picsum.photos/100/100'
  },
];

class Ejercicio3Listas extends StatelessWidget {
  const Ejercicio3Listas({Key? key, required this.datos}) : super(key: key);
  final List<Map<String, dynamic>> datos;

  @override
  Widget build(BuildContext context) {
    return ListView(
        children: datos
            .map((e) => ListTile(
                  title: Text(e['title']),
                  subtitle: Text(e['subtitle']),
                  leading: FadeInImage.assetNetwork(
                      placeholder:
                          'assets/images/mr_incredible_becoming_uncanny.jpeg',
                      image: e['leading']),
                ))
            .toList());
  }
}
//Crea un StatelessWidget que devolva unha lista de ListTiles,
// no que se apliquen os datos definidos na constante anterior.
// Para a imaxe emprega un FadeInImage.
