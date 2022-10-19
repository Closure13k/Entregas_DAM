import 'package:flutter/material.dart';

class MiListaExtensa extends StatelessWidget {
  const MiListaExtensa({Key? key, required this.datos}) : super(key: key);
  final List<Map<String, dynamic>> datos;

  @override
  Widget build(BuildContext context) {
    return ListView.builder(
        itemCount: datos.length,
        itemBuilder: (_, pos) {
          print(pos);
          return SizedBox(
            height: 200,
            child: Text('Dato: ${datos.elementAt(pos)}'),
          );
        });
  }
}

class MiListaExtensaConSeparacion extends StatelessWidget {
  const MiListaExtensaConSeparacion({Key? key, required this.datos})
      : super(key: key);
  final List<Map<String, dynamic>> datos;

  @override
  Widget build(BuildContext context) {
    return ListView.separated(
        itemCount: datos.length,
        separatorBuilder: (BuildContext context, int index) => Divider(
              thickness: 20,
              color: index % 2 == 0 ? Colors.green : Colors.red,
            ),
        itemBuilder: (_, pos) {
          print(pos);
          return SizedBox(
            height: 200,
            child: Text('Dato: ${datos.elementAt(pos)}'),
          );
        });
  }
}
