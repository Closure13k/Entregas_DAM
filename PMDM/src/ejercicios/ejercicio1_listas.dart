import 'package:flutter/material.dart';

final datosExercicio1 = <Map<String, dynamic>>[
  {'texto': 'Etiqueta 1', 'color': Colors.blue, 'size': 20.0},
  {'texto': 'Etiqueta 2', 'color': Colors.red, 'size': 30.0},
  {'texto': 'Etiqueta 3', 'color': Colors.green, 'size': 25.0},
  {'texto': 'Etiqueta 4', 'color': Colors.yellow, 'size': 40.0},
];

class Ejercicio1Listas extends StatelessWidget {
  const Ejercicio1Listas({Key? key, required this.datos}) : super(key: key);
  final List<Map<String, dynamic>> datos;

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return ListView(
        children: datos
            .map((element) => Text(
                  'Texto: ${element['texto']}',
                  style: TextStyle(
                      color: element['color'], fontSize: element['size']),
                ))
            .toList());
  }
}
