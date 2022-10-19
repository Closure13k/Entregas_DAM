import 'package:flutter/material.dart';
import 'package:practica_examen/app_examen.dart';
import 'package:practica_examen/screens/screens.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    var appRoutes = {
      'home': (_) => HomeScreen(),
      'details': (_) => DetailScreen()
    };
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Películas',
      initialRoute: 'home',
      routes: appRoutes,
      theme: ThemeData.light().copyWith(
        appBarTheme: AppBarTheme(
          color: Colors.teal
        )
      ),
    );
  }
}
