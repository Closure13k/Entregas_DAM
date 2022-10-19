import 'dart:ui';

import 'package:flutter/material.dart';

class EjercicioContenedores extends StatelessWidget {
  const EjercicioContenedores({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text('Ejercicio Containers'),
        ),
        body: contendores2(context));
  }

  Widget contenedores1(BuildContext context) {
    return Column(
      children: [
        Container(
          alignment: Alignment.topCenter,
          padding: EdgeInsets.only(top: 10),
          width: double.infinity,
          color: Colors.red,
          height: 50,
          child: Text('Uno'),
        ),
        Expanded(
          flex: 1,
          child: Container(
            margin: EdgeInsets.only(top: 10),
            padding: EdgeInsets.all(10),
            width: MediaQuery.of(context).size.width * 0.5,
            color: Colors.blue,
            child: Text('Contenedor 2'),
          ),
        ),
        Expanded(
          child: Container(
            margin: EdgeInsets.all(10),
            width: double.infinity,
            color: Colors.yellow,
            child: Center(child: Text('Uno')),
          ),
        )
      ],
    );
  }

  Widget contendores2(BuildContext context) {
    return Column(
      children: [
        Container(
          height: 250,
          width: 250,
          color: Colors.red,
          child: Align(
            alignment: Alignment.topRight,
            child: Container(
              color: Colors.yellow,
              width: 50,
              height: 50,
            ),
          ),
        )
      ],
    );
  }
}
