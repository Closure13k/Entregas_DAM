import 'package:flutter/material.dart';

class InicioPage extends StatelessWidget {
  const InicioPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) => Scaffold(
      appBar: AppBar(
        title: Text('Inicio'),
        actions: [
          IconButton(
            onPressed: () {},
            icon: Icon(Icons.accessible_forward_sharp),
            color: Colors.red,
          )
        ],
      ),
      body: Text('hola'));
}
