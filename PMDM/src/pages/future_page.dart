import 'package:flutter/material.dart';


class FuturePage extends StatelessWidget {
  const FuturePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Futuras')),
      body: FutureBuilder(
        builder: (BuildContext buildContext,
                AsyncSnapshot<List<String>> snapshot) =>
            snapshot.hasData
                ? ListView.builder(
                    itemCount: snapshot.data!.length,
                    itemBuilder: (_, index) => SizedBox(
                        child: FadeInImage(
                            placeholder: AssetImage(
                                'assets/images/mr_incredible_becoming_uncanny.jpeg'),
                            image:
                                NetworkImage(snapshot.data!.elementAt(index)))),
                  )
                : Center(child: CircularProgressIndicator()),
        future: getImagesFromInternet(),
      ),
    );
  }
}

Future<List<String>> getImagesFromInternet() {
  final _datos = {
    'elementos': [
      {
        "description":"Lady with a red umbrella",
        "url":"https://i.imgur.com/pwpWaWu.jpg"
      },
      {
        "description":"Flowers and some fruits",
        "url":"https://i.imgur.com/KIPtISY.jpg"
      },
      {
        "description":"Beautiful scenery",
        "url":"https://i.imgur.com/2jMCqQ2.jpg"
      },
      {
        "description":"Some kind of bird",
        "url":"https://i.imgur.com/QFDRuAh.jpg"
      },
      {
        "description":"The attack of dragons",
        "url":"https://i.imgur.com/8yIIokW.jpg"
      }
    ]
  };
  List<String> list = _datos['elementos']!.map((e) => e['url']!).toList();
  return Future.delayed(Duration(seconds: 5), () => list);
}

Future<List<String>> getDatosDeInternet() {
  final _datos = {
    'elementos': [
      {'nome': 'Angel'},
      {'nome': 'Pepe'},
      {'nome': 'Angel'},
      {'nome': 'Pepe'},
      {'nome': 'Angel'},
      {'nome': 'Pepe'},
      {'nome': 'Angel'},
      {'nome': 'Pepe'},
      {'nome': 'Angel'},
      {'nome': 'Pepe'},
      {'nome': 'Angel'},
      {'nome': 'Pepe'},
      {'nome': 'Angel'},
      {'nome': 'Pepe'},
      {'nome': 'Angel'},
      {'nome': 'Pepe'},
      {'nome': 'Angel'},
      {'nome': 'Pepe'},
      {'nome': 'Angel'},
    ]
  };
  List<String> listNames = _datos['elementos']!.map((e) => e['nome']!).toList();

  return Future.delayed(Duration(seconds: 5), () => listNames);
}
