<?php
//https://www.hackerrank.com/contests/booking-passions-hacked-backend/challenges/destinations-together-3
$_fp = fopen("php://stdin", "r");
$ar = explode(" ", fgets($_fp));

$n = $ar[0];
$m = $ar[1];
$c = $ar[2];

$n -= $c;
$m -= $c;

function factorial($size) {
    if($size == 1 || $size == 0) return 1;
    return factorial($size-1) * $size;
}

echo(factorial($n + $m + $c - 1));
