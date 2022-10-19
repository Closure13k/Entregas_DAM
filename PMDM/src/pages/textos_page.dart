import 'package:flutter/material.dart';
import 'package:flutter_html/flutter_html.dart';
import 'package:url_launcher/url_launcher.dart';
import 'package:url_launcher/url_launcher_string.dart';

class TextosPage extends StatelessWidget {
  const TextosPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    const estiloPropio =
        TextStyle(color: Colors.red, fontStyle: FontStyle.italic);
    return Scaffold(
        appBar: AppBar(
          title: const Text('Textos'),
        ),
        body: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Html(
              data: '<b>Hola Mundo</b> desde HTML enlace a <a href= "https://www.google.es">google</a>',
              onLinkTap: (enlace,_,__,___) => _launchUrl(Uri.parse(enlace!)),
            ),
            const Text('Primer texto'),
            const Text(
              'Segundo texto asdo,kado ak osk dokaso kasdask oaskd oaks dokasd okoa kasodkoasdkoaksdokaoskasdokas kodao aosdkoasdk asdo kasds',
              overflow: TextOverflow.ellipsis,
              maxLines: 2,
            ),
            DefaultTextStyle(
                style: estiloPropio,
                child: Column(
                  children: const [
                    Text('Texto1'),
                    Text('Texto2'),
                  ],
                )),
            RichText(
                text: const TextSpan(
                    text: 'TextoRico',
                    style: const TextStyle(color: Colors.blue),
                    children: [const TextSpan(text: 'niño')])),
          ],
        )
    );
  }
}
Future<void> _launchUrl(Uri url) async {
  if (!await launchUrl(url)) {
    throw 'Could not launch $url';
  }
}
