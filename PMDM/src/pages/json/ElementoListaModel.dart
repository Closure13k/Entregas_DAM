class ElementoListaModel {
  String titulo;
  String texto;
  String imagenURL;

  ElementoListaModel(
      {required this.titulo, required this.texto, required this.imagenURL});

  factory ElementoListaModel.fromMap(Map<String, String> datos) =>
      ElementoListaModel(
          titulo: datos!['titulo'] ?? 'Valor no encontrado',
          texto: datos!['texto'] ?? 'Texto no encontrado',
          imagenURL: datos['imagen'] ??
              'assets/images/mr_incredible_becoming_uncanny.jpeg');
}
