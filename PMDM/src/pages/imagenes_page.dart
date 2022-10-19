import 'package:flutter/material.dart';

class ImagenesPage extends StatelessWidget {
  const ImagenesPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) => Scaffold(
        appBar: AppBar(
          title: Text('Imagenes'),
        ),
        body: Column(
          children: [
            FadeInImage(
              placeholder:
                  AssetImage('assets/gifs/mr-incredible-becoming-canny.gif'),
              image: NetworkImage('https://picsum.photos/100/100'),
              fadeInDuration: Duration(seconds: 2),
              fadeOutDuration: Duration(seconds: 10),
              height: 200,
              width: 200,
            ),
            Image.asset('assets/images/mr_incredible_becoming_uncanny.jpeg'),
            Image.asset(
              'assets/gifs/mr-incredible-becoming-canny.gif',
              width: 200,
              height: 200,
            ),
            Image(
              image: AssetImage('assets/gifs/mr-incredible-becoming-canny.gif'),
              width: 200,
              height: 200,
            ),
            Image.network(
              "https://picsum.photos/400/600",
              width: 100,
              height: 100,
              fit: BoxFit.fill,
            ),
            Image(
              image: NetworkImage('https://picsum.photos/300/600'),
              width: 100,
              height: 100,
            ),
          ],
        ),
      );
}
