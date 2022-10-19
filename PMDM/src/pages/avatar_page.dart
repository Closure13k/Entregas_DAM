import 'package:flutter/material.dart';

class AvatarPage extends StatelessWidget {
  const AvatarPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text('Avatar page'),
        ),
        body: Column(
          children: [
            CircleAvatar(
              backgroundColor: Colors.lightBlueAccent,
              radius: 50,
              child: Text('A'),
            ),
            CircleAvatar(
              backgroundColor: Colors.lightBlueAccent,
              radius: 200,
              backgroundImage:
                  AssetImage('assets/gifs/mr-incredible-becoming-canny.gif'),
            ),
          ],
        ));
  }
}
