package rank

import (
    "sort"
)

func Alternate(s string) int32 {
    if len(s) == 0 {
        return 0
    }

    runes := []rune(s)

    var frequencies map[rune]int = make(map[rune]int)
    var doubles map[rune]bool = make(map[rune]bool)

    var current rune
    var previous rune

    for i := 0; i < len(runes); i++ {
        current = runes[i]
        if previous == current {
            doubles[current] = true
            continue
        }

        if _, exist := frequencies[current]; exist {
            frequencies[current]++ 
        } else {
            frequencies[current] = 1
        }
    }

    //remove doubles
    for key, _ := range doubles {
        delete(frequencies, key)
    }

    if len(frequencies) < 1 {
        return 0
    }

    var freqEntries Entries
    for key, freq := range frequencies  {
        freqEntries = append(freqEntries, Entry{Key: key, Freq: freq})
    }

    sort.Sort(freqEntries)
    var pairs PairEntries
    for i := 0; i < len(freqEntries) - 1; i++ {
        iEntry := freqEntries[i]
        for j := i + 1; j < len(freqEntries); j++ {
            jEntry := freqEntries[j]

            diff := iEntry.Freq - jEntry.Freq
            if diff <= 1 && diff >= -1 {
                pairs = append(pairs, [2]Entry{iEntry, jEntry})
            }
        }
    }

    sort.Sort(pairs)
    for i := len(pairs) - 1; i >= 0; i-- {
        pair := pairs[i]

        if IsAlternate(runes, pair[0].Key, pair[1].Key) {
            return int32(pair[0].Freq + pair[1].Freq)
        }
    }

    return 0
}

func IsAlternate(runes []rune, runeA rune, runeB rune) bool {
    var prevRune rune

    for _, currRune := range runes {
        if currRune != runeA && currRune != runeB {
            continue
        }

        if currRune == prevRune {
            return false
        }

        prevRune = currRune
    }

    return true
}

type Entries []Entry
type Entry struct {
    Key rune
    Freq int
}

func (entries Entries) Len() int {
    return len(entries)
}

func (entries Entries) Less(i, j int) bool {
    return entries[i].Freq < entries[j].Freq
}

func (entries Entries) Swap(i, j int) {
    entries[i], entries[j] = entries[j], entries[i]
}

type PairEntries []PairEntry
type PairEntry [2]Entry
func (pairEntries PairEntries) Len() int {
    return len(pairEntries)
}

func (pairEntries PairEntries) Less(i, j int) bool {
    iPairEntry := pairEntries[i]
    iSum := iPairEntry[0].Freq + iPairEntry[1].Freq

    jPairEntry := pairEntries[j]
    jSum := jPairEntry[0].Freq + jPairEntry[1].Freq

    return iSum < jSum
}

func (pairEntries PairEntries) Swap(i, j int) {
    pairEntries[i], pairEntries[j] = pairEntries[j], pairEntries[i]
}
