package rank

import (
    "testing"
    "sort"
)

func TestLen(t *testing.T) {
    entries := Entries{{Key: rune('a'), Freq: 5}}
    if entries.Len() != 1 {
        t.Errorf("the length of entries should be 1")
    }
}

func TestLess(t *testing.T) {
    entries := Entries{{Key: rune('a'), Freq: 6}, {Key: rune('b'), Freq: 5}}

    if entries.Less(0,1) {
        t.Errorf("the length of entries is not less")
    }
}

func TestSwap(t *testing.T) {
    entries := Entries{{Key: rune('a'), Freq: 6}, {Key: rune('b'), Freq: 5}}

    entries.Swap(0, 1)

    if entries[0].Key != rune('b') {
        t.Errorf("swap is not going ok")
    }
}

func TestSort(t *testing.T) {
    entries := Entries{{Key: rune('a'), Freq: 10}, {Key: rune('b'), Freq: 9}, {Key: rune('c'), Freq: 8}}
    
    sort.Sort(entries)
    if entries[0].Key != rune('c') || entries[1].Key != rune('b') || entries[2].Key != rune('a') {
        t.Errorf("not sorting properly")
    }
}

func TestIsAlternate(t *testing.T) {
    runes := []rune("")
    if IsAlternate(runes, rune('a'), rune('b')) == false {
        t.Errorf("empty string should be alternative")
    }

    runes = []rune("a")
    if IsAlternate(runes, 'a', 'b') == false {
        t.Errorf("string of one character should be alternative")
    }

    runes = []rune("aa")
    if IsAlternate(runes, 'a', 'b') == true {
        t.Errorf("string of two same characters should be not alternative")
    }

    runes = []rune("aba")
    if IsAlternate(runes, 'a', 'b') == false {
        t.Errorf("'aba' should be alternative")
    }

    runes = []rune("abab")
    if IsAlternate(runes, 'a', 'b') == false {
        t.Errorf("'abab' should be alternative")
    }

    runes = []rune("abaab")
    if IsAlternate(runes, 'a', 'b') == true {
        t.Errorf("'abab' should be not alternative")
    }
}

func TestAlternate(t *testing.T) {
    s := "beabeefeab"
    rez := Alternate(s)
    if rez != 5 {
        t.Errorf("Rez := %d, but should be 5", rez)
    }
}
