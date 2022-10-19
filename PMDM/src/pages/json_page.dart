import 'package:first_project/src/pages/json/ElementoListaModel.dart';
import 'package:flutter/material.dart';
import 'package:first_project/src/pages/json/DatosProvider.dart';

class JsonPage extends StatelessWidget {
  const JsonPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) => Scaffold(
      appBar: AppBar(
        title: Text('JSON PAGE'),
      ),
      body: _listaDatos());

  @override
  Widget _listaDatos() => FutureBuilder(
        future: datosProvider.cargarDatos(),
        builder: (BuildContext context,
                AsyncSnapshot<List<ElementoListaModel>> snapshot) =>
            snapshot.hasData
                ? ListView.builder(
                    itemCount: snapshot.data!.length,
                    itemBuilder: (_, pos) =>
                        _elementoListaWidget(snapshot.data!.elementAt(pos)))
                : CircularProgressIndicator(),
      );

  Widget _elementoListaWidget(ElementoListaModel elemento) => ListTile(
        title: Text('Titulo: ${elemento.titulo}'),
        subtitle: Text('Subtitulo: ${elemento.texto}'),
        leading:
            CircleAvatar(backgroundImage: NetworkImage(elemento.imagenURL)),
      );
}
