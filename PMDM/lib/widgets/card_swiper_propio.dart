import 'package:card_swiper/card_swiper.dart';
import 'package:flutter/material.dart';

class CardSwiperPropio extends StatelessWidget {
  const CardSwiperPropio({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    final screenSize = MediaQuery.of(context).size;
    return Container(
      height: screenSize.height * 0.5,
      width: double.infinity,
      color: Colors.pinkAccent,
      child: Swiper(
        layout: SwiperLayout.TINDER,
        itemCount: 10,
        itemHeight: screenSize.height*0.4,
        itemWidth: screenSize.width*0.6,
        itemBuilder: (_, int pos) => ClipRRect(
          borderRadius: BorderRadius.horizontal(left: Radius.circular(0), right:Radius.circular(180) ),
          child: Container(
            color: Colors.green,
            child: Center(
                child: Text(
              pos.toString(),
              style: TextStyle(fontSize: 72),
            )),
            height: 50,
            width: 50,
          ),
        ),
        scrollDirection: Axis.horizontal,
      ),
    );
  }
}
