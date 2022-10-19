import 'package:first_project/src/pages/json/ElementoListaModel.dart';

class _DatosProvider {
  final _datos = {
    "elementos": [
      {
        "titulo": "Elemento 1",
        "texto": "Aclaración elemento 1",
        "imagen": "https://picsum.photos/id/1/200/300"
      },
      {
        "titulo": "Elemento 2",
        "texto": "Aclaración elemento 2",
        "imagen": "https://picsum.photos/id/2/200/300"
      },
      {
        "titulo": "Elemento 3",
        "texto": "Aclaración elemento 3",
        "imagen": "https://picsum.photos/id/3/200/300"
      },
      {
        "titulo": "Elemento 4",
        "texto": "Aclaración elemento 4",
        "imagen": "https://picsum.photos/id/4/200/300"
      },
      {
        "titulo": "Elemento 5",
        "texto": "Aclaración elemento 5",
        "imagen": "https://picsum.photos/id/5/200/300"
      },
      {
        "titulo": "Elemento 6",
        "texto": "Aclaración elemento 6",
        "imagen": "https://picsum.photos/id/6/200/300"
      },
      {
        "titulo": "Elemento 7",
        "texto": "Aclaración elemento 7",
        "imagen": "https://picsum.photos/id/7/200/300"
      },
      {
        "titulo": "Elemento 8",
        "texto": "Aclaración elemento 8",
        "imagen": "https://picsum.photos/id/8/200/300"
      },
      {
        "titulo": "Elemento 9",
        "texto": "Aclaración elemento 9",
        "imagen": "https://picsum.photos/id/9/200/300"
      },
      {
        "titulo": "Elemento 10",
        "texto": "Aclaración elemento 10",
        "imagen": "https://picsum.photos/id/10/200/300"
      },
      {
        "titulo": "Elemento 11",
        "texto": "Aclaración elemento 11",
        "imagen": "https://picsum.photos/id/11/200/300"
      },
      {
        "titulo": "Elemento 12",
        "texto": "Aclaración elemento 12",
        "imagen": "https://picsum.photos/id/12/200/300"
      },
      {
        "titulo": "Elemento 13",
        "texto": "Aclaración elemento 13",
        "imagen": "https://picsum.photos/id/13/200/300"
      }
    ]
  };

  Future<List<ElementoListaModel>> cargarDatos() async => Future.delayed(
      Duration(seconds: 5),
      () => _datos['elementos']!.map(ElementoListaModel.fromMap).toList());
}

final datosProvider = _DatosProvider();
