import 'package:first_project/src/pages/design/columnas_filas_page.dart';
import 'package:first_project/src/pages/json_page.dart';
import 'package:flutter/material.dart';

import 'ejercicios/ejercicio_contenedores.dart';

class MiMaterialApp extends StatelessWidget {
  const MiMaterialApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) => MaterialApp(
        debugShowCheckedModeBanner: false,
        home: EjercicioContenedores(),
        theme: ThemeData.light(),
      );
}
