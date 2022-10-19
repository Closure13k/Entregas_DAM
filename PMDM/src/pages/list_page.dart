import 'package:flutter/material.dart';

class ListPage extends StatelessWidget {
  ListPage({Key? key}) : super(key: key);
  final datosJSON = [
    {"Titulo": "Titulo1", "Icon": "estrella"},
    {"Titulo": "Titulo1", "Icon": "estrella"},
    {"Titulo": "Titulo1", "Icon": "estrella"},
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('ListPage'),
      ),
      body: ListView(
        children: [
          Column(
            children: _obtenerLista(datos: ['asd', 'abv', 'bcd']),
          ),
          ListTile(
            title: Text('Titulo'),
            leading: Icon(Icons.accessible),
            subtitle: Text('Subtitulo'),
          ),
          Text('HOLA'),
          Image(
            image:
            AssetImage('assets/images/mr_incredible_becoming_uncanny.jpeg'),
            height: 100,
            width: 100,
          ),
        ],
      ),
    );
  }

  List<Widget> _obtenerLista({required List<String> datos}) =>
      datos.map((e) => ListTile(title: Text(e))).toList();

//Los datos vendrán en forma de la lista, y cada elemento será un mapa.
//Los mapas estarán formados por dos datos: 'Titulo':'Titulo1', 'Icon':'NombreIcono'
//A mayores: Un mapa con iconos predefinidos que devolverá el icono en base a lo que lee del mapa de datos.

//Definir un Stateless Widget que devuelva
}
