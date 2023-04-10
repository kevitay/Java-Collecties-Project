package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.Game;
import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.CollectieType;

public class Infernia extends Collectie {

  public Infernia() {
    super(CollectieType.ELEMENTAL, "burnnnn");
  }

  public String getGraphic() {
    return"                           .-.                                    \n" +
          "                   .::::---+%#*=---------------::                 \n" +
          "             ..........:----=#.*#=------------:......             \n" +
          "            .----------------% :=*#--------------...              \n" +
          "                     .------*= :--=#+---+**------::::::::.        \n" +
          "             .:::----------*+ .-----#++%%*-----------::::.        \n" +
          "                 .-------=#- :-==---+%#%%+----------:.            \n" +
          "      .-----------------+*. :---++=--=-*%%*------------....       \n" +
          "        ........-------+* .---==++++=---=*%%*----------:::::::.   \n" +
          "          ::::::------+* .--=+=++++++=+=--=#%%+---------------:.  \n" +
          "              :-------%  --=++++++++++++=---+%%*-----:            \n" +
          "        :------------*= --=++*#*++++++*#*+=--+%%+-----.           \n" +
          "        ........:----%. --+++%@%++++++#@%++=--#%%------:...       \n" +
          "            ....:----%..--++#*++%%%%%%++*#++--*%@------....       \n" +
          "            ---------#:.--=+#*+++****+++*#++--*%%---------:       \n" +
          "                      -* --=++++++++++++++++=--#%=                \n" +
          "                      +=:--=++++++++++++++=--+%*                  \n" +
          "                       =*----==++++++++==---*%+                   \n" +
          "                        .+*=------===-----+#*:                    \n" +
          "                          -**----------**=.                       \n" +
          "                             =#=**==+*=#=                         \n" +
          "            :-----------------*%#----*%*----------------:         \n" +
          "             ...........................................          \n";
  }

  @Override
  public Biome getPreferredBiome() {
    return Biome.VOLCANIC;
  }

  @Override
  public int performAttack() {
    return 15;
  }

  @Override
  public boolean defend(int attackStrength) {
    if(Game.TEST_MODE) return false;
    return Game.randogen.nextInt(100) > 50;
  }

  @Override
  public Infernia clone() {
    return new Infernia();
  }
}
