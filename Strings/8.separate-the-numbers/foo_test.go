package m

import (
    "testing"
)

func TestIsBeatifulStringForNumber(t *testing.T) {
    var inStr, inNumber string
    var out, expected bool

    inStr = ""
    inNumber = "01"
    expected = false
    out = IsBeatifulStringForNumber(inStr, inNumber)
    if out != expected {
        t.Errorf("inStr:=%s inNumber:=%s out:=%t expected:=%t", inStr, inNumber, out, expected)
    }

    inStr = "1234"
    inNumber = "1"
    expected = true
    out = IsBeatifulStringForNumber(inStr, inNumber)
    if out != expected {
        t.Errorf("inStr:=%s inNumber:=%s out:=%t expected:=%t", inStr, inNumber, out, expected)
    }

    inStr = "91011"
    inNumber = "9"
    expected = true
    out = IsBeatifulStringForNumber(inStr, inNumber)
    if out != expected {
        t.Errorf("inStr:=%s inNumber:=%s out:=%t expected:=%t", inStr, inNumber, out, expected)
    }

    inStr = "101103"
    inNumber = "10"
    expected = false
    out = IsBeatifulStringForNumber(inStr, inNumber)
    if out != expected {
        t.Errorf("inStr:=%s inNumber:=%s out:=%t expected:=%t", inStr, inNumber, out, expected)
    }

    inStr = "10203"
    inNumber = "1"
    expected = false
    out = IsBeatifulStringForNumber(inStr, inNumber)
    if out != expected {
        t.Errorf("inStr:=%s inNumber:=%s out:=%t expected:=%t", inStr, inNumber, out, expected)
    }

    inStr = "13"
    inNumber = "1"
    expected = false
    out = IsBeatifulStringForNumber(inStr, inNumber)
    if out != expected {
        t.Errorf("inStr:=%s inNumber:=%s out:=%t expected:=%t", inStr, inNumber, out, expected)
    }

    inStr = "1"
    inNumber = "1"
    expected = false
    out = IsBeatifulStringForNumber(inStr, inNumber)
    if out != expected {
        t.Errorf("inStr:=%s inNumber:=%s out:=%t expected:=%t", inStr, inNumber, out, expected)
    }
}

func TestSeparateNumbers(t *testing.T) {
    var in, out, expected string

    /*
    in = "1234"
    expected = "YES 1"
    out = SeparateNumbers(in)
    if out != expected {
        t.Errorf("in:=%s out:=%s expected:=%s", in, out, expected)
    }

    in = "91011"
    expected = "YES 9"
    out = SeparateNumbers(in)
    if out != expected {
        t.Errorf("in:=%s out:=%s expected:=%s", in, out, expected)
    }

    in = "99100"
    expected = "YES 99"
    out = SeparateNumbers(in)
    if out != expected {
        t.Errorf("in:=%s out:=%s expected:=%s", in, out, expected)
    }

    in = "101103"
    expected = "NO"
    out = SeparateNumbers(in)
    if out != expected {
        t.Errorf("in:=%s out:=%s expected:=%s", in, out, expected)
    }

    in = "010203"
    expected = "NO"
    out = SeparateNumbers(in)
    if out != expected {
        t.Errorf("in:=%s out:=%s expected:=%s", in, out, expected)
    }

    in = "13"
    expected = "NO"
    out = SeparateNumbers(in)
    if out != expected {
        t.Errorf("in:=%s out:=%s expected:=%s", in, out, expected)
    }

    in = "1"
    expected = "NO"
    out = SeparateNumbers(in)
    if out != expected {
        t.Errorf("in:=%s out:=%s expected:=%s", in, out, expected)
    }

    in = "99910001001"
    expected = "YES 999"
    out = SeparateNumbers(in)
    if out != expected {
        t.Errorf("in:=%s out:=%s expected:=%s", in, out, expected)
    }

    in = "7891011"
    expected = "YES 7"
    out = SeparateNumbers(in)
    if out != expected {
        t.Errorf("in:=%s out:=%s expected:=%s", in, out, expected)
    }

    in = "9899100"
    expected = "YES 98"
    out = SeparateNumbers(in)
    if out != expected {
        t.Errorf("in:=%s out:=%s expected:=%s", in, out, expected)
    }

    in = "999100010001"
    expected = "NO"
    out = SeparateNumbers(in)
    if out != expected {
        t.Errorf("in:=%s out:=%s expected:=%s", in, out, expected)
    }
    */

    in = "99332720572758669933272057275867"
    expected = "YES 9933272057275866"
    out = SeparateNumbers(in)
    if out != expected {
        t.Errorf("in:=%s out:=%s expected:=%s", in, out, expected)
    }
}
