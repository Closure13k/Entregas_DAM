import 'package:flutter/material.dart';

class ColumnasFilasPage extends StatelessWidget {
  const ColumnasFilasPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) => Scaffold(
      appBar: AppBar(
        title: Text('Filas y columnas'),
      ),
      body: buildColumn2(context));

  Widget buildColumn(BuildContext context) => Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Expanded(
            flex: 10,
            child: Container(
              width: MediaQuery.of(context).size.width * 0.90,
              height: 100,
              color: Colors.red,
            ),
          ),
          Expanded(
            flex: 10,
            child: Container(
              width: 100,
              height: 100,
              color: Colors.blue,
            ),
          ),
          Expanded(
            flex: 20,
            child: Container(
              width: 100,
              height: 100,
              color: Colors.green,
            ),
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: [
              Icon(Icons.accessible_forward_sharp, size: 80),
              Icon(
                Icons.add_circle,
                size: 60,
              ),
              Icon(
                Icons.accessible_forward_sharp,
                size: 40,
              ),
            ],
          ),
          Text(
            'asdadasdasd',
            style: TextStyle(backgroundColor: Colors.red, fontSize: 50),
          ),
        ],
      );

  Widget buildExampleRow() => Stack(children: [
        Image.network('https://picsum.photos/500/800'),
        SingleChildScrollView(
          scrollDirection: Axis.horizontal,
          child: Row(
            children: [
              Text('texto1'),
              Text('texto2'),
              Text(
                'texto3asd a das dad asd asd adasdasd akdms idma ismdiam diams iams idm assads',
                style: TextStyle(backgroundColor: Colors.red),
              ),
            ],
          ),
        ),
      ]);

  Widget buildColumn2(BuildContext context) =>
      Column(mainAxisAlignment: MainAxisAlignment.center, children: [
        Expanded(
          flex: 10,
          child: Container(
            padding: EdgeInsets.all(20),
            margin: EdgeInsets.fromLTRB(10, 20, 10, 10),
            width: 100,
            height: 100,
            color: Colors.red,
          ),
        ),
        Spacer(flex: 3,),
        Expanded(
          flex: 10,
          child: Container(
            width: 100,
            height: 100,
            color: Colors.blue,
          ),
        ),
        Spacer(flex: 5,),
        Container(
          width: 100,
          height: 100,
          color: Colors.green,
        ),
      ]);
}
