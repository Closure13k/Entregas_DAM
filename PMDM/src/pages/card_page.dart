import 'package:flutter/material.dart';

class CardPage extends StatelessWidget {
  const CardPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text('Cards'),
        ),
        body: ListView(
          children: [
            Card(
              shape: RoundedRectangleBorder(
                  side: BorderSide(width: 100, color: Colors.red),
                  borderRadius: BorderRadius.all(Radius.circular(150))),
              elevation: 100,
              child: Column(
                children: [
                  Image.network(
                    "https://picsum.photos/500",
                    fit: BoxFit.fill,
                  ),
                  Text('hola tarjeta'),
                ],
              ),
            )
          ],
        ));
  }
}
