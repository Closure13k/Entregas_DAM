import 'package:flutter/material.dart';

class BotonesPage extends StatelessWidget {
  const BotonesPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      floatingActionButton: Row(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          TextButton(
            onPressed: () => {},
            child: Text('TextButton'),
            style: TextButton.styleFrom(
                backgroundColor: Colors.pink, primary: Colors.white),
          ),
          IconButton(
            onPressed: () => {},
            icon: Icon(Icons.zoom_in_map_outlined),
          ),
          FloatingActionButton.extended(
            onPressed: () => {},
            icon: Icon(Icons.ad_units),
            label: Text('Texto'),
          ),
          ElevatedButton(
            onPressed: () => {},
            child: Text('elevatedButton'),
          ),
        ],
      ),
      floatingActionButtonLocation: FloatingActionButtonLocation.startFloat,
      appBar: AppBar(
        title: Text('Botones'),
      ),
      body: Column(
        children: [
          FloatingActionButton(
            onPressed: () => {},
            //Si en vez de vacía se usa null, el botón se deshabilita
            child: Icon(Icons.accessible_forward_sharp),
            tooltip: 'Ejemplo botón',
          ),
        ],
      ),
    );
  }
}
