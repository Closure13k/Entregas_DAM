import 'package:first_project/src/ejercicios/ejercicio1_listas.dart';
import 'package:first_project/src/ejercicios/ejercicio2_listas.dart';
import 'package:first_project/src/ejercicios/ejercicio3_listas.dart';
import 'package:first_project/src/pages/future_page.dart';
import 'package:first_project/src/pages/list_page2.dart';
import 'package:flutter/material.dart';

class _MainPage extends StatelessWidget {
  const _MainPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: MiScaffold(),
    );
  }
}

class MiScaffold extends StatelessWidget {
  const MiScaffold({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text('Exercicios Listas'),
        ),
        body: FuturePage());
  }
}
