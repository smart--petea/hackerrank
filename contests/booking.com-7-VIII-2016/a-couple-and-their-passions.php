<?php
//https://www.hackerrank.com/contests/booking-passions-hacked-backend/challenges/a-couple-and-their-passions

function degree2radians( $ls ) {
    return $ls * 3.14159265359/ 180;
}

function distance_between($lat1, $lng1, $lat2, $lng2) {
    $EARTH_RADIUS = 6371;//in km
    $point1_lat_in_radians  = degree2radians( $lat1 );
    $point2_lat_in_radians  = degree2radians( $lat2 );
    $point1_long_in_radians  = degree2radians( $lng1 );
    $point2_long_in_radians  = degree2radians( $lng2 );

    return acos( sin( $point1_lat_in_radians ) * sin( $point2_lat_in_radians ) +
                 cos( $point1_lat_in_radians ) * cos( $point2_lat_in_radians ) *
                 cos( $point2_long_in_radians - $point1_long_in_radians) ) * $EARTH_RADIUS;
}

class Destination {
    static public $destinations = array();

    public $name;
    public $lat;
    public $lng;

    public $passions = array();

    private function Destination($line) {
        $ar = explode(" ", $line);

        $this->name = $ar[0];
        $this->lat = $ar[1];
        $this->lng = $ar[2];

        $passionsSize = $ar[3];
        for($i = 0; $i <  $passionsSize; $i++) $this->passions[$i] = $ar[$i + 4];
    }

    public static function add($line) {
        self::$destinations[] = new Destination($line);
    }

    public static function process($guestPassions) {
        $allGuestPassions = array_unique(call_user_func_array(array_merge, $guestPassions));

        $max = 0;
        $destinationRating = array();
        $destinationsCnt = count(self::$destinations);
        for($i = 0; $i < $destinationsCnt; $i++) {
            $iD = self::$destinations[$i];
            for($j = $i + 1; $j < $destinationsCnt; $j++) {
                $jD = self::$destinations[$j];
                $cnt = sizeof(array_unique(array_intersect(array_merge($iD->passions, $jD->passions), $allGuestPassions)));
                if($cnt > $max) {
                    $max = $cnt;
                    array_unshift($destinationRating, array($i, $j, $cnt));
                }
            }
        }

        $destinationRatingTop = array();
        $i = 0;
        while($destinationRating[$i][2] == $max) {
            $destinationRatingTop[] = $destinationRating[$i];
            $i++;
        }

        if($i == 1) return array(self::$destinations[$destinationRatingTop[0][1]]->name, self::$destinations[$destinationRatingTop[0][0]]->name);


        $destinationsCnt = sizeof($destinationRatingTop);
        $min = distance_between($destinationRatingTop[0][0]->lat, $destinationRatingTop[0][0]->lng, $destinationRatingTop[0][1]->lat, $destinationRatingTop[0][1]->lng);
        $minIndex = 0;
        $i = 1;
        while($i < $destinationsCnt) {
            $dst =  distance_between($destinationRatingTop[$i][0]->lat, $destinationRatingTop[$i][0]->lng, $destinationRatingTop[$i][1]->lat, $destinationRatingTop[$i][1]->lng);
            if($min > $dst) {
                $min = $dst;
                $minIndex = $i;
            }
            ++$i;
        }

        return array(self::$destinations[$destinationRatingTop[$minIndex][1]]->name, self::$destinations[$destinationRatingTop[$minIndex][0]]->name);
    }
}

$_fp = fopen("php://stdin", "r");

$m = (int)fgets($_fp);
$guestPassions = array();
for($i = 0; $i < $m; $i++) {
    $guestPassions[$i] = explode(" ", trim(fgets($_fp)));
    array_shift($guestPassions[$i]);
}


//destinations
$y = (int)fgets($_fp);
$destinations = array();
for($i = 0; $i < $y; $i ++) Destination::add(trim(fgets($_fp)));

$rez = Destination::process($guestPassions);
if($rez[0] < $rez[1]) {
    echo $rez[0] . " " . $rez[1];
} else {
    echo $rez[1] . " " . $rez[0];
}
