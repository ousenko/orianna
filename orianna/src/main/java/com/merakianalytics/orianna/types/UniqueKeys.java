package com.merakianalytics.orianna.types;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.merakianalytics.orianna.types.common.Platform;
import com.merakianalytics.orianna.types.common.Queue;
import com.merakianalytics.orianna.types.common.Tier;
import com.merakianalytics.orianna.types.core.championmastery.ChampionMasteries;
import com.merakianalytics.orianna.types.core.championmastery.ChampionMastery;
import com.merakianalytics.orianna.types.core.championmastery.ChampionMasteryScore;
import com.merakianalytics.orianna.types.core.league.League;
import com.merakianalytics.orianna.types.core.league.LeaguePositions;
import com.merakianalytics.orianna.types.core.match.Match;
import com.merakianalytics.orianna.types.core.match.Timeline;
import com.merakianalytics.orianna.types.core.match.TournamentMatches;
import com.merakianalytics.orianna.types.core.spectator.CurrentMatch;
import com.merakianalytics.orianna.types.core.spectator.FeaturedMatches;
import com.merakianalytics.orianna.types.core.staticdata.Champion;
import com.merakianalytics.orianna.types.core.staticdata.Champions;
import com.merakianalytics.orianna.types.core.staticdata.Item;
import com.merakianalytics.orianna.types.core.staticdata.Items;
import com.merakianalytics.orianna.types.core.staticdata.LanguageStrings;
import com.merakianalytics.orianna.types.core.staticdata.Languages;
import com.merakianalytics.orianna.types.core.staticdata.Map;
import com.merakianalytics.orianna.types.core.staticdata.Maps;
import com.merakianalytics.orianna.types.core.staticdata.Masteries;
import com.merakianalytics.orianna.types.core.staticdata.Mastery;
import com.merakianalytics.orianna.types.core.staticdata.ProfileIcon;
import com.merakianalytics.orianna.types.core.staticdata.ProfileIcons;
import com.merakianalytics.orianna.types.core.staticdata.Realm;
import com.merakianalytics.orianna.types.core.staticdata.ReforgedRune;
import com.merakianalytics.orianna.types.core.staticdata.ReforgedRunes;
import com.merakianalytics.orianna.types.core.staticdata.Rune;
import com.merakianalytics.orianna.types.core.staticdata.Runes;
import com.merakianalytics.orianna.types.core.staticdata.SummonerSpell;
import com.merakianalytics.orianna.types.core.staticdata.SummonerSpells;
import com.merakianalytics.orianna.types.core.staticdata.Versions;
import com.merakianalytics.orianna.types.core.status.ShardStatus;
import com.merakianalytics.orianna.types.core.summoner.Summoner;
import com.merakianalytics.orianna.types.core.thirdpartycode.VerificationString;
import com.merakianalytics.orianna.types.dto.league.LeagueList;
import com.merakianalytics.orianna.types.dto.league.SummonerPositions;
import com.merakianalytics.orianna.types.dto.match.MatchTimeline;
import com.merakianalytics.orianna.types.dto.spectator.CurrentGameInfo;
import com.merakianalytics.orianna.types.dto.spectator.FeaturedGames;
import com.merakianalytics.orianna.types.dto.staticdata.ChampionList;
import com.merakianalytics.orianna.types.dto.staticdata.ItemList;
import com.merakianalytics.orianna.types.dto.staticdata.MapData;
import com.merakianalytics.orianna.types.dto.staticdata.MapDetails;
import com.merakianalytics.orianna.types.dto.staticdata.MasteryList;
import com.merakianalytics.orianna.types.dto.staticdata.ProfileIconData;
import com.merakianalytics.orianna.types.dto.staticdata.ProfileIconDetails;
import com.merakianalytics.orianna.types.dto.staticdata.ReforgedRuneTree;
import com.merakianalytics.orianna.types.dto.staticdata.RuneList;
import com.merakianalytics.orianna.types.dto.staticdata.SummonerSpellList;

public abstract class UniqueKeys {
    private static final Set<Tier> UNIQUE_TIERS = ImmutableSet.of(Tier.CHALLENGER, Tier.MASTER);

    public static int[] forChampion(final Champion champion) {
        final com.merakianalytics.orianna.types.data.staticdata.Champion data = champion.getCoreData().getChampion();
        if(data.getId() != 0 && data.getName() != null && data.getKey() != null) {
            return new int[] {
                Arrays.hashCode(new Object[] {
                    Champion.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getId(), data.getIncludedData()
                }),
                Arrays.hashCode(new Object[] {
                    Champion.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getName(), data.getIncludedData()
                }),
                Arrays.hashCode(new Object[] {
                    Champion.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getKey(), data.getIncludedData()
                })
            };
        } else if(data.getId() != 0 && data.getName() != null) {
            return new int[] {
                Arrays.hashCode(new Object[] {
                    Champion.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getId(), data.getIncludedData()
                }),
                Arrays.hashCode(new Object[] {
                    Champion.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getName(), data.getIncludedData()
                })
            };
        } else if(data.getId() != 0 && data.getKey() != null) {
            return new int[] {
                Arrays.hashCode(new Object[] {
                    Champion.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getId(), data.getIncludedData()
                }),
                Arrays.hashCode(new Object[] {
                    Champion.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getKey(), data.getIncludedData()
                })
            };
        } else if(data.getName() != null && data.getKey() != null) {
            return new int[] {
                Arrays.hashCode(new Object[] {
                    Champion.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getName(), data.getIncludedData()
                }),
                Arrays.hashCode(new Object[] {
                    Champion.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getKey(), data.getIncludedData()
                })
            };
        } else if(data.getId() != 0) {
            return new int[] {
                Arrays.hashCode(new Object[] {
                    Champion.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getId(), data.getIncludedData()
                })
            };
        } else if(data.getName() != null) {
            return new int[] {
                Arrays.hashCode(new Object[] {
                    Champion.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getName(), data.getIncludedData()
                })
            };
        } else if(data.getKey() != null) {
            return new int[] {
                Arrays.hashCode(new Object[] {
                    Champion.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getKey(), data.getIncludedData()
                })
            };
        } else {
            throw new IllegalArgumentException("Can't get key for Champion without ID, name, or key!");
        }
    }

    public static int[] forChampionDto(final com.merakianalytics.orianna.types.dto.staticdata.Champion champion) {
        return new int[] {
            Arrays.hashCode(new Object[] {
                com.merakianalytics.orianna.types.dto.staticdata.Champion.class.getCanonicalName(), champion.getPlatform(), champion.getVersion(),
                champion.getLocale(), champion.getId(), champion.getIncludedData()
            }),
            Arrays.hashCode(new Object[] {
                com.merakianalytics.orianna.types.dto.staticdata.Champion.class.getCanonicalName(), champion.getPlatform(), champion.getVersion(),
                champion.getLocale(), champion.getName(), champion.getIncludedData()
            }),
            Arrays.hashCode(new Object[] {
                com.merakianalytics.orianna.types.dto.staticdata.Champion.class.getCanonicalName(), champion.getPlatform(), champion.getVersion(),
                champion.getLocale(), champion.getKey(), champion.getIncludedData()
            })
        };
    }

    @SuppressWarnings("unchecked")
    public static int forChampionDtoQuery(final java.util.Map<String, Object> query) {
        final Number id = (Number)query.get("id");
        final String name = (String)query.get("name");
        final String key = (String)query.get("key");
        return Arrays.hashCode(new Object[] {
            com.merakianalytics.orianna.types.dto.staticdata.Champion.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(),
            (String)query.get("version"), (String)query.get("locale"),
            id == null ? name == null ? key : name : id.intValue(), (Set<String>)query.get("includedData")
        });
    }

    public static int forChampionListDto(final ChampionList champions) {
        return Arrays.hashCode(new Object[] {
            ChampionList.class.getCanonicalName(), champions.getPlatform(), champions.getVersion(), champions.getLocale(), champions.getIncludedData(),
            champions.isDataById()
        });
    }

    @SuppressWarnings("unchecked")
    public static int forChampionListDtoQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            ChampionList.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), (String)query.get("version"), (String)query.get("locale"),
            (Set<String>)query.get("includedData"), (Boolean)query.get("dataById")
        });
    }

    public static int forChampionMasteries(final ChampionMasteries masteries) {
        final com.merakianalytics.orianna.types.data.championmastery.ChampionMasteries data = masteries.getCoreData();
        return Arrays.hashCode(new Object[] {
            ChampionMasteries.class.getCanonicalName(), data.getPlatform(), data.getSummonerId()
        });
    }

    public static int forChampionMasteriesDto(final com.merakianalytics.orianna.types.dto.championmastery.ChampionMasteries masteries) {
        return Arrays.hashCode(new Object[] {
            com.merakianalytics.orianna.types.dto.championmastery.ChampionMasteries.class.getCanonicalName(), masteries.getPlatform(), masteries.getSummonerId()
        });
    }

    public static int forChampionMasteriesDtoQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            com.merakianalytics.orianna.types.dto.championmastery.ChampionMasteries.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(),
            ((Number)query.get("summonerId")).longValue()
        });
    }

    public static int forChampionMasteriesQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            ChampionMasteries.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), ((Number)query.get("summonerId")).longValue()
        });
    }

    public static int forChampionMastery(final ChampionMastery mastery) {
        final com.merakianalytics.orianna.types.data.championmastery.ChampionMastery data = mastery.getCoreData();
        return Arrays.hashCode(new Object[] {
            ChampionMastery.class.getCanonicalName(), data.getPlatform(), data.getSummonerId(), data.getChampionId()
        });
    }

    public static int forChampionMasteryDto(final com.merakianalytics.orianna.types.dto.championmastery.ChampionMastery mastery) {
        return Arrays.hashCode(new Object[] {
            com.merakianalytics.orianna.types.dto.championmastery.ChampionMastery.class.getCanonicalName(), mastery.getPlatform(), mastery.getPlayerId(),
            mastery.getChampionId()
        });
    }

    public static int forChampionMasteryDtoQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            com.merakianalytics.orianna.types.dto.championmastery.ChampionMastery.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(),
            ((Number)query.get("summonerId")).longValue(),
            ((Number)query.get("championId")).longValue()
        });
    }

    public static int forChampionMasteryQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            ChampionMastery.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), ((Number)query.get("summonerId")).longValue(),
            ((Number)query.get("championId")).intValue()
        });
    }

    public static int forChampionMasteryScore(final ChampionMasteryScore score) {
        final com.merakianalytics.orianna.types.data.championmastery.ChampionMasteryScore data = score.getCoreData();
        return Arrays.hashCode(new Object[] {
            ChampionMasteryScore.class.getCanonicalName(), data.getPlatform(), data.getSummonerId()
        });
    }

    public static int forChampionMasteryScoreDto(final com.merakianalytics.orianna.types.dto.championmastery.ChampionMasteryScore score) {
        return Arrays.hashCode(new Object[] {
            com.merakianalytics.orianna.types.dto.championmastery.ChampionMasteryScore.class.getCanonicalName(), score.getPlatform(), score.getSummonerId()
        });
    }

    public static int forChampionMasteryScoreDtoQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            com.merakianalytics.orianna.types.dto.championmastery.ChampionMasteryScore.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(),
            ((Number)query.get("summonerId")).longValue()
        });
    }

    public static int forChampionMasteryScoreQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            ChampionMasteryScore.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), ((Number)query.get("summonerId")).longValue()
        });
    }

    @SuppressWarnings("unchecked")
    public static int forChampionQuery(final java.util.Map<String, Object> query) {
        final Number id = (Number)query.get("id");
        final String name = (String)query.get("name");
        final String key = (String)query.get("key");
        return Arrays.hashCode(new Object[] {
            Champion.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), (String)query.get("version"), (String)query.get("locale"),
            id == null ? name == null ? key : name : id.intValue(), (Set<String>)query.get("includedData")
        });
    }

    public static int forChampions(final Champions champions) {
        final com.merakianalytics.orianna.types.data.staticdata.Champions data = champions.getCoreData();
        return Arrays.hashCode(new Object[] {
            Champions.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getIncludedData()
        });
    }

    @SuppressWarnings("unchecked")
    public static int forChampionsQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            Champions.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), (String)query.get("version"), (String)query.get("locale"),
            (Set<String>)query.get("includedData")
        });
    }

    public static int forChampionStatusDto(final com.merakianalytics.orianna.types.dto.champion.Champion champion) {
        return Arrays.hashCode(new Object[] {
            com.merakianalytics.orianna.types.dto.champion.Champion.class.getCanonicalName(), champion.getPlatform(), champion.getId()
        });
    }

    public static int forChampionStatusDtoQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            com.merakianalytics.orianna.types.dto.champion.Champion.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(),
            ((Number)query.get("id")).longValue()
        });
    }

    public static int forChampionStatusListDto(final com.merakianalytics.orianna.types.dto.champion.ChampionList champions) {
        return Arrays.hashCode(new Object[] {
            com.merakianalytics.orianna.types.dto.champion.ChampionList.class.getCanonicalName(), champions.getPlatform(), champions.isFreeToPlay()
        });
    }

    public static int forChampionStatusListDtoQuery(final java.util.Map<String, Object> query) {
        final Boolean freeToPlay = query.get("freeToPlay") == null ? Boolean.FALSE : (Boolean)query.get("freeToPlay");

        return Arrays.hashCode(new Object[] {
            com.merakianalytics.orianna.types.dto.champion.ChampionList.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(),
            freeToPlay.booleanValue()
        });
    }

    public static int forCurrentGameInfoDto(final CurrentGameInfo game) {
        return Arrays.hashCode(new Object[] {
            CurrentGameInfo.class.getCanonicalName(), game.getPlatformId(), game.getSummonerId()
        });
    }

    public static int forCurrentGameInfoDtoQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            CurrentGameInfo.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), ((Number)query.get("summonerId")).longValue()
        });
    }

    public static int forCurrentMatch(final CurrentMatch game) {
        final com.merakianalytics.orianna.types.data.spectator.CurrentMatch data = game.getCoreData();
        return Arrays.hashCode(new Object[] {
            CurrentMatch.class.getCanonicalName(), data.getPlatform(), data.getSummonerId()
        });
    }

    public static int forCurrentMatchQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            CurrentMatch.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), ((Number)query.get("summonerId")).longValue()
        });
    }

    public static int forFeaturedGamesDto(final FeaturedGames games) {
        return Arrays.hashCode(new Object[] {
            FeaturedGames.class.getCanonicalName(), games.getPlatform()
        });
    }

    public static int forFeaturedGamesDtoQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            FeaturedGames.class.getCanonicalName(), ((Platform)query.get("platform")).getTag()
        });
    }

    public static int forFeaturedMatches(final FeaturedMatches games) {
        final com.merakianalytics.orianna.types.data.spectator.FeaturedMatches data = games.getCoreData();
        return Arrays.hashCode(new Object[] {
            FeaturedMatches.class.getCanonicalName(), data.getPlatform()
        });
    }

    public static int forFeaturedMatchesQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            FeaturedMatches.class.getCanonicalName(), ((Platform)query.get("platform")).getTag()
        });
    }

    public static int[] forItem(final Item item) {
        final com.merakianalytics.orianna.types.data.staticdata.Item data = item.getCoreData();
        if(data.getId() != 0 && data.getName() != null) {
            return new int[] {
                Arrays.hashCode(new Object[] {
                    Item.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getId(), data.getIncludedData()
                }),
                Arrays.hashCode(new Object[] {
                    Item.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getName(), data.getIncludedData()
                })
            };
        } else if(data.getId() != 0) {
            return new int[] {
                Arrays.hashCode(new Object[] {
                    Item.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getId(), data.getIncludedData()
                })
            };
        } else if(data.getName() != null) {
            return new int[] {
                Arrays.hashCode(new Object[] {
                    Item.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getName(), data.getIncludedData()
                })
            };
        } else {
            throw new IllegalArgumentException("Can't get key for Item without ID or name!");
        }
    }

    public static int[] forItemDto(final com.merakianalytics.orianna.types.dto.staticdata.Item item) {
        return new int[] {
            Arrays.hashCode(new Object[] {
                com.merakianalytics.orianna.types.dto.staticdata.Item.class.getCanonicalName(), item.getPlatform(), item.getVersion(), item.getLocale(),
                item.getId(), item.getIncludedData()
            }),
            Arrays.hashCode(new Object[] {
                com.merakianalytics.orianna.types.dto.staticdata.Item.class.getCanonicalName(), item.getPlatform(), item.getVersion(), item.getLocale(),
                item.getName(), item.getIncludedData()
            })
        };
    }

    @SuppressWarnings("unchecked")
    public static int forItemDtoQuery(final java.util.Map<String, Object> query) {
        final Number id = (Number)query.get("id");
        final String name = (String)query.get("name");
        return Arrays.hashCode(new Object[] {
            com.merakianalytics.orianna.types.dto.staticdata.Item.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(),
            (String)query.get("version"), (String)query.get("locale"),
            id == null ? name : id.intValue(), (Set<String>)query.get("includedData")
        });
    }

    public static int forItemListDto(final ItemList items) {
        return Arrays.hashCode(new Object[] {
            ItemList.class.getCanonicalName(), items.getPlatform(), items.getVersion(), items.getLocale(), items.getIncludedData()
        });
    }

    @SuppressWarnings("unchecked")
    public static int forItemListDtoQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            ItemList.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), (String)query.get("version"), (String)query.get("locale"),
            (Set<String>)query.get("includedData")
        });
    }

    @SuppressWarnings("unchecked")
    public static int forItemQuery(final java.util.Map<String, Object> query) {
        final Number id = (Number)query.get("id");
        final String name = (String)query.get("name");
        return Arrays.hashCode(new Object[] {
            Item.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), (String)query.get("version"), (String)query.get("locale"),
            id == null ? name : id.intValue(), (Set<String>)query.get("includedData")
        });
    }

    public static int forItems(final Items items) {
        final com.merakianalytics.orianna.types.data.staticdata.Items data = items.getCoreData();
        return Arrays.hashCode(new Object[] {
            Items.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getIncludedData()
        });
    }

    @SuppressWarnings("unchecked")
    public static int forItemsQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            Items.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), (String)query.get("version"), (String)query.get("locale"),
            (Set<String>)query.get("includedData")
        });
    }

    public static int forLanguages(final Languages languages) {
        final com.merakianalytics.orianna.types.data.staticdata.Languages data = languages.getCoreData();
        return Arrays.hashCode(new Object[] {
            Languages.class.getCanonicalName(), data.getPlatform()
        });
    }

    public static int forLanguagesDto(final com.merakianalytics.orianna.types.dto.staticdata.Languages languages) {
        return Arrays.hashCode(new Object[] {
            com.merakianalytics.orianna.types.dto.staticdata.Languages.class.getCanonicalName(), languages.getPlatform()
        });
    }

    public static int forLanguagesDtoQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            com.merakianalytics.orianna.types.dto.staticdata.Languages.class.getCanonicalName(), ((Platform)query.get("platform")).getTag()
        });
    }

    public static int forLanguagesQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            Languages.class.getCanonicalName(), ((Platform)query.get("platform")).getTag()
        });
    }

    public static int forLanguageStrings(final LanguageStrings languageStrings) {
        final com.merakianalytics.orianna.types.data.staticdata.LanguageStrings data = languageStrings.getCoreData();
        return Arrays.hashCode(new Object[] {
            LanguageStrings.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale()
        });
    }

    public static int forLanguageStringsDto(final com.merakianalytics.orianna.types.dto.staticdata.LanguageStrings languageStrings) {
        return Arrays.hashCode(new Object[] {
            com.merakianalytics.orianna.types.dto.staticdata.LanguageStrings.class.getCanonicalName(), languageStrings.getPlatform(),
            languageStrings.getVersion(), languageStrings.getLocale()
        });
    }

    public static int forLanguageStringsDtoQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            com.merakianalytics.orianna.types.dto.staticdata.LanguageStrings.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(),
            (String)query.get("version"), (String)query.get("locale")
        });
    }

    public static int forLanguageStringsQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            LanguageStrings.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), (String)query.get("version"), (String)query.get("locale")
        });
    }

    public static int[] forLeague(final League league) {
        final com.merakianalytics.orianna.types.data.league.League data = league.getCoreData();
        if(data.getTier() != null && data.getQueue() != null && UNIQUE_TIERS.contains(league.getTier()) && Queue.RANKED.contains(league.getQueue())) {
            if(data.getId() != null) {
                return new int[] {
                    Arrays.hashCode(new Object[] {
                        League.class.getCanonicalName(), data.getPlatform(), data.getId()
                    }),
                    Arrays.hashCode(new Object[] {
                        League.class.getCanonicalName(), data.getPlatform(), data.getTier(), data.getQueue()
                    })
                };
            } else {
                return new int[] {
                    Arrays.hashCode(new Object[] {
                        League.class.getCanonicalName(), data.getPlatform(), data.getTier(), data.getQueue()
                    })
                };
            }
        } else if(data.getId() != null) {
            return new int[] {
                Arrays.hashCode(new Object[] {
                    League.class.getCanonicalName(), data.getPlatform(), data.getId()
                })
            };
        } else {
            throw new IllegalArgumentException("Can't get key for League without ID or queue and tier!");
        }
    }

    public static int[] forLeagueListDto(final LeagueList league) {
        return new int[] {
            Arrays.hashCode(new Object[] {
                LeagueList.class.getCanonicalName(), league.getPlatform(), league.getLeagueId()
            }),
            Arrays.hashCode(new Object[] {
                LeagueList.class.getCanonicalName(), league.getPlatform(), league.getTier(), league.getQueue()
            })
        };
    }

    public static int forLeagueListDtoQuery(final java.util.Map<String, Object> query) {
        final String id = (String)query.get("leagueId");
        if(id != null) {
            return Arrays.hashCode(new Object[] {
                LeagueList.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), id
            });
        } else {
            return Arrays.hashCode(new Object[] {
                LeagueList.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), ((Tier)query.get("tier")).name(),
                ((Queue)query.get("queue")).name()
            });
        }
    }

    public static int forLeaguePositions(final LeaguePositions positions) {
        final com.merakianalytics.orianna.types.data.league.LeaguePositions data = positions.getCoreData();
        return Arrays.hashCode(new Object[] {
            LeaguePositions.class.getCanonicalName(), data.getPlatform(), data.getSummonerId()
        });
    }

    public static int forLeaguePositionsQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            LeaguePositions.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), ((Number)query.get("summonerId")).longValue()
        });
    }

    public static int forLeagueQuery(final java.util.Map<String, Object> query) {
        final String id = (String)query.get("leagueId");
        if(id != null) {
            return Arrays.hashCode(new Object[] {
                League.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), id
            });
        } else {
            return Arrays.hashCode(new Object[] {
                League.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), ((Tier)query.get("tier")).name(),
                ((Queue)query.get("queue")).name()
            });
        }
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyChampionDtoQuery(final java.util.Map<String, Object> query) {
        final Iterable<Number> ids = (Iterable<Number>)query.get("ids");
        final Iterable<String> names = (Iterable<String>)query.get("names");
        final Iterable<String> keys = (Iterable<String>)query.get("keys");

        final Iterator<?> iterator = ids != null ? ids.iterator() : names != null ? names.iterator() : keys.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    com.merakianalytics.orianna.types.dto.staticdata.Champion.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(),
                    (String)query.get("version"), (String)query.get("locale"),
                    ids != null ? ((Number)iterator.next()).intValue() : iterator.next(), (Set<String>)query.get("includedData")
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyChampionListDtoQuery(final java.util.Map<String, Object> query) {
        final Iterable<String> versions = (Iterable<String>)query.get("versions");

        final Iterator<String> iterator = versions.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    ChampionList.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), iterator.next(), (String)query.get("locale"),
                    (Set<String>)query.get("includedData"), (Boolean)query.get("dataById")
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyChampionMasteriesDtoQuery(final java.util.Map<String, Object> query) {
        final Iterable<Number> ids = (Iterable<Number>)query.get("summonerIds");

        final Iterator<Number> iterator = ids.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    com.merakianalytics.orianna.types.dto.championmastery.ChampionMasteries.class.getCanonicalName(),
                    ((Platform)query.get("platform")).getTag(), iterator.next().longValue()
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };

    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyChampionMasteriesQuery(final java.util.Map<String, Object> query) {
        final Iterable<Number> summonerIds = (Iterable<Number>)query.get("summonerIds");

        final Iterator<Number> iterator = summonerIds.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    ChampionMasteries.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), iterator.next().longValue()
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyChampionMasteryDtoQuery(final java.util.Map<String, Object> query) {
        final Iterable<Number> ids = (Iterable<Number>)query.get("championIds");

        final Iterator<Number> iterator = ids.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    com.merakianalytics.orianna.types.dto.championmastery.ChampionMastery.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(),
                    ((Number)query.get("summonerId")).longValue(), iterator.next().longValue()
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyChampionMasteryQuery(final java.util.Map<String, Object> query) {
        final Iterable<Number> championIds = (Iterable<Number>)query.get("championIds");

        final Iterator<Number> iterator = championIds.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    ChampionMastery.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), ((Number)query.get("summonerId")).longValue(),
                    iterator.next().intValue()
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyChampionMasteryScoreDtoQuery(final java.util.Map<String, Object> query) {
        final Iterable<Number> ids = (Iterable<Number>)query.get("summonerIds");

        final Iterator<Number> iterator = ids.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    com.merakianalytics.orianna.types.dto.championmastery.ChampionMasteryScore.class.getCanonicalName(),
                    ((Platform)query.get("platform")).getTag(), iterator.next().longValue()
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyChampionMasteryScoreQuery(final java.util.Map<String, Object> query) {
        final Iterable<Number> summonerIds = (Iterable<Number>)query.get("summonerIds");

        final Iterator<Number> iterator = summonerIds.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    ChampionMasteryScore.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), iterator.next().longValue()
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyChampionQuery(final java.util.Map<String, Object> query) {
        final Iterable<Number> ids = (Iterable<Number>)query.get("ids");
        final Iterable<String> names = (Iterable<String>)query.get("names");
        final Iterable<String> keys = (Iterable<String>)query.get("keys");

        final Iterator<?> iterator;
        if(ids != null) {
            iterator = ids.iterator();
        } else if(names != null) {
            iterator = names.iterator();
        } else if(keys != null) {
            iterator = keys.iterator();
        } else {
            return null;
        }

        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    Champion.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), (String)query.get("version"), (String)query.get("locale"),
                    ids != null ? ((Number)iterator.next()).intValue() : iterator.next(), (Set<String>)query.get("includedData")
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyChampionStatusDtoQuery(final java.util.Map<String, Object> query) {
        final Iterable<Number> ids = (Iterable<Number>)query.get("ids");

        final Iterator<Number> iterator = ids.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    com.merakianalytics.orianna.types.dto.champion.Champion.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(),
                    iterator.next().longValue()
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyChampionStatusListDtoQuery(final java.util.Map<String, Object> query) {
        final Iterable<Platform> platforms = (Iterable<Platform>)query.get("platforms");
        final Boolean freeToPlay = query.get("freeToPlay") == null ? Boolean.FALSE : (Boolean)query.get("freeToPlay");

        final Iterator<Platform> iterator = platforms.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    com.merakianalytics.orianna.types.dto.champion.ChampionList.class.getCanonicalName(), iterator.next().getTag(), freeToPlay.booleanValue()
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyCurrentGameInfoDtoQuery(final java.util.Map<String, Object> query) {
        final Iterable<Number> ids = (Iterable<Number>)query.get("summonerIds");

        final Iterator<Number> iterator = ids.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    CurrentGameInfo.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), iterator.next().longValue()
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyCurrentMatchQuery(final java.util.Map<String, Object> query) {
        final Iterable<Number> summonerIds = (Iterable<Number>)query.get("summonerIds");

        final Iterator<Number> iterator = summonerIds.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    CurrentMatch.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), iterator.next().longValue()
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyFeaturedGamesDtoQuery(final java.util.Map<String, Object> query) {
        final Iterable<Platform> platforms = (Iterable<Platform>)query.get("platforms");

        final Iterator<Platform> iterator = platforms.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    FeaturedGames.class.getCanonicalName(), iterator.next().getTag()
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyFeaturedMatchesQuery(final java.util.Map<String, Object> query) {
        final Iterable<Platform> platforms = (Iterable<Platform>)query.get("platforms");

        final Iterator<Platform> iterator = platforms.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    FeaturedMatches.class.getCanonicalName(), iterator.next().getTag()
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyItemDtoQuery(final java.util.Map<String, Object> query) {
        final Iterable<Number> ids = (Iterable<Number>)query.get("ids");
        final Iterable<String> names = (Iterable<String>)query.get("names");

        final Iterator<?> iterator = ids != null ? ids.iterator() : names.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    com.merakianalytics.orianna.types.dto.staticdata.Item.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(),
                    (String)query.get("version"), (String)query.get("locale"),
                    ids != null ? ((Number)iterator.next()).intValue() : iterator.next(), (Set<String>)query.get("includedData")
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyItemListDtoQuery(final java.util.Map<String, Object> query) {
        final Iterable<String> versions = (Iterable<String>)query.get("versions");

        final Iterator<String> iterator = versions.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    ItemList.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), iterator.next(), (String)query.get("locale"),
                    (Set<String>)query.get("includedData")
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyItemQuery(final java.util.Map<String, Object> query) {
        final Iterable<Number> ids = (Iterable<Number>)query.get("ids");
        final Iterable<String> names = (Iterable<String>)query.get("names");

        final Iterator<?> iterator;
        if(ids != null) {
            iterator = ids.iterator();
        } else if(names != null) {
            iterator = names.iterator();
        } else {
            return null;
        }

        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    Item.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), (String)query.get("version"), (String)query.get("locale"),
                    ids != null ? ((Number)iterator.next()).intValue() : iterator.next(), (Set<String>)query.get("includedData")
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyLanguagesDtoQuery(final java.util.Map<String, Object> query) {
        final Iterable<Platform> platforms = (Iterable<Platform>)query.get("platforms");

        final Iterator<Platform> iterator = platforms.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    com.merakianalytics.orianna.types.dto.staticdata.Languages.class.getCanonicalName(), iterator.next().getTag()
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyLanguageStringsDtoQuery(final java.util.Map<String, Object> query) {
        final Iterable<String> locales = (Iterable<String>)query.get("locales");

        final Iterator<String> iterator = locales.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    com.merakianalytics.orianna.types.dto.staticdata.LanguageStrings.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(),
                    (String)query.get("version"), iterator.next()
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyLeagueListDtoQuery(final java.util.Map<String, Object> query) {
        final Iterable<Queue> queues = (Iterable<Queue>)query.get("queues");
        final Iterable<String> leagueIds = (Iterable<String>)query.get("leagueIds");

        final Iterator<?> iterator = leagueIds != null ? leagueIds.iterator() : queues.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                if(leagueIds != null) {
                    return Arrays.hashCode(new Object[] {
                        LeagueList.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), (String)iterator.next()
                    });
                } else {
                    return Arrays.hashCode(new Object[] {
                        LeagueList.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), ((Tier)query.get("tier")).name(),
                        ((Queue)iterator.next()).name()
                    });
                }
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyLeaguePositionsQuery(final java.util.Map<String, Object> query) {
        final Iterable<Number> summonerIds = (Iterable<Number>)query.get("summonerIds");

        final Iterator<Number> iterator = summonerIds.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    LeaguePositions.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), iterator.next().longValue()
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyLeagueQuery(final java.util.Map<String, Object> query) {
        final Iterable<String> leagueIds = (Iterable<String>)query.get("leagueIds");
        final Iterable<Queue> queues = (Iterable<Queue>)query.get("queues");

        final Iterator<?> iterator = leagueIds != null ? leagueIds.iterator() : queues.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                if(leagueIds != null) {
                    return Arrays.hashCode(new Object[] {
                        League.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), iterator.next()
                    });
                } else {
                    return Arrays.hashCode(new Object[] {
                        League.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), ((Tier)query.get("tier")).name(),
                        ((Queue)iterator.next()).name()
                    });
                }
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyMapDataDtoQuery(final java.util.Map<String, Object> query) {
        final Iterable<String> versions = (Iterable<String>)query.get("versions");

        final Iterator<String> iterator = versions.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    MapData.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), iterator.next(), (String)query.get("locale")
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyMapDetailsDtoQuery(final java.util.Map<String, Object> query) {
        final Iterable<Number> ids = (Iterable<Number>)query.get("ids");
        final Iterable<String> names = (Iterable<String>)query.get("names");

        final Iterator<?> iterator = ids != null ? ids.iterator() : names.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    MapDetails.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), (String)query.get("version"), (String)query.get("locale"),
                    ids != null ? ((Number)iterator.next()).longValue() : iterator.next()
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyMapQuery(final java.util.Map<String, Object> query) {
        final Iterable<Number> ids = (Iterable<Number>)query.get("ids");
        final Iterable<String> names = (Iterable<String>)query.get("names");

        final Iterator<?> iterator;
        if(ids != null) {
            iterator = ids.iterator();
        } else if(names != null) {
            iterator = names.iterator();
        } else {
            return null;
        }

        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    Map.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), (String)query.get("version"), (String)query.get("locale"),
                    ids != null ? ((Number)iterator.next()).intValue() : iterator.next()
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyMasteryDtoQuery(final java.util.Map<String, Object> query) {
        final Iterable<Number> ids = (Iterable<Number>)query.get("ids");
        final Iterable<String> names = (Iterable<String>)query.get("names");

        final Iterator<?> iterator = ids != null ? ids.iterator() : names.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    com.merakianalytics.orianna.types.dto.staticdata.Mastery.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(),
                    (String)query.get("version"), (String)query.get("locale"),
                    ids != null ? ((Number)iterator.next()).intValue() : iterator.next(), (Set<String>)query.get("includedData")
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyMasteryListDtoQuery(final java.util.Map<String, Object> query) {
        final Iterable<String> versions = (Iterable<String>)query.get("versions");

        final Iterator<String> iterator = versions.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    MasteryList.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), iterator.next(), (String)query.get("locale"),
                    (Set<String>)query.get("includedData")
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyMasteryQuery(final java.util.Map<String, Object> query) {
        final Iterable<Number> ids = (Iterable<Number>)query.get("ids");
        final Iterable<String> names = (Iterable<String>)query.get("names");

        final Iterator<?> iterator;
        if(ids != null) {
            iterator = ids.iterator();
        } else if(names != null) {
            iterator = names.iterator();
        } else {
            return null;
        }

        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    Mastery.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), (String)query.get("version"), (String)query.get("locale"),
                    ids != null ? ((Number)iterator.next()).intValue() : iterator.next(), (Set<String>)query.get("includedData")
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyMatchDtoQuery(final java.util.Map<String, Object> query) {
        final Iterable<Number> ids = (Iterable<Number>)query.get("matchIds");

        final Iterator<Number> iterator = ids.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    com.merakianalytics.orianna.types.dto.match.Match.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(),
                    iterator.next().longValue()
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyMatchQuery(final java.util.Map<String, Object> query) {
        final Iterable<Number> matchIds = (Iterable<Number>)query.get("matchIds");

        final Iterator<Number> iterator = matchIds.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    Match.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), iterator.next().longValue()
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyMatchTimelineDtoQuery(final java.util.Map<String, Object> query) {
        final Iterable<Number> ids = (Iterable<Number>)query.get("matchIds");

        final Iterator<Number> iterator = ids.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    MatchTimeline.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), iterator.next().longValue()
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyProfileIconDataDtoQuery(final java.util.Map<String, Object> query) {
        final Iterable<String> versions = (Iterable<String>)query.get("versions");

        final Iterator<String> iterator = versions.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    ProfileIconData.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), iterator.next(), (String)query.get("locale")
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyProfileIconDetailsDtoQuery(final java.util.Map<String, Object> query) {
        final Iterable<Number> ids = (Iterable<Number>)query.get("ids");

        final Iterator<Number> iterator = ids.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    ProfileIconDetails.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), (String)query.get("version"),
                    (String)query.get("locale"),
                    iterator.next().longValue()
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyProfileIconQuery(final java.util.Map<String, Object> query) {
        final Iterable<Number> ids = (Iterable<Number>)query.get("ids");

        final Iterator<Number> iterator = ids.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    ProfileIcon.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), (String)query.get("version"), (String)query.get("locale"),
                    iterator.next().intValue()
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyRealmDtoQuery(final java.util.Map<String, Object> query) {
        final Iterable<Platform> platforms = (Iterable<Platform>)query.get("platforms");

        final Iterator<Platform> iterator = platforms.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    com.merakianalytics.orianna.types.dto.staticdata.Realm.class.getCanonicalName(), iterator.next().getTag()
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyReforgedRuneDtoQuery(final java.util.Map<String, Object> query) {
        final Iterable<Number> ids = (Iterable<Number>)query.get("ids");
        final Iterable<String> names = (Iterable<String>)query.get("names");
        final Iterable<String> keys = (Iterable<String>)query.get("keys");

        final Iterator<?> iterator = ids != null ? ids.iterator() : names != null ? names.iterator() : keys.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    com.merakianalytics.orianna.types.dto.staticdata.ReforgedRune.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(),
                    (String)query.get("version"), (String)query.get("locale"),
                    ids != null ? ((Number)iterator.next()).intValue() : iterator.next()
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyReforgedRuneQuery(final java.util.Map<String, Object> query) {
        final Iterable<Number> ids = (Iterable<Number>)query.get("ids");
        final Iterable<String> names = (Iterable<String>)query.get("names");
        final Iterable<String> keys = (Iterable<String>)query.get("keys");

        final Iterator<?> iterator;
        if(ids != null) {
            iterator = ids.iterator();
        } else if(names != null) {
            iterator = names.iterator();
        } else if(keys != null) {
            iterator = keys.iterator();
        } else {
            return null;
        }

        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    ReforgedRune.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), (String)query.get("version"),
                    (String)query.get("locale"),
                    ids != null ? ((Number)iterator.next()).intValue() : iterator.next()
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyReforgedRuneTreeDtoQuery(final java.util.Map<String, Object> query) {
        final Iterable<String> versions = (Iterable<String>)query.get("versions");

        final Iterator<String> iterator = versions.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    ReforgedRuneTree.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), iterator.next(), (String)query.get("locale")
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyRuneDtoQuery(final java.util.Map<String, Object> query) {
        final Iterable<Number> ids = (Iterable<Number>)query.get("ids");
        final Iterable<String> names = (Iterable<String>)query.get("names");

        final Iterator<?> iterator = ids != null ? ids.iterator() : names.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    com.merakianalytics.orianna.types.dto.staticdata.Rune.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(),
                    (String)query.get("version"), (String)query.get("locale"),
                    ids != null ? ((Number)iterator.next()).intValue() : iterator.next(), (Set<String>)query.get("includedData")
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyRuneListDtoQuery(final java.util.Map<String, Object> query) {
        final Iterable<String> versions = (Iterable<String>)query.get("versions");

        final Iterator<String> iterator = versions.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    RuneList.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), iterator.next(), (String)query.get("locale"),
                    (Set<String>)query.get("includedData")
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyRuneQuery(final java.util.Map<String, Object> query) {
        final Iterable<Number> ids = (Iterable<Number>)query.get("ids");
        final Iterable<String> names = (Iterable<String>)query.get("names");

        final Iterator<?> iterator;
        if(ids != null) {
            iterator = ids.iterator();
        } else if(names != null) {
            iterator = names.iterator();
        } else {
            return null;
        }

        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    Rune.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), (String)query.get("version"), (String)query.get("locale"),
                    ids != null ? ((Number)iterator.next()).intValue() : iterator.next(), (Set<String>)query.get("includedData")
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyShardStatusDtoQuery(final java.util.Map<String, Object> query) {
        final Iterable<Platform> platforms = (Iterable<Platform>)query.get("platforms");

        final Iterator<Platform> iterator = platforms.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    com.merakianalytics.orianna.types.dto.status.ShardStatus.class.getCanonicalName(), iterator.next().getTag()
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyShardStatusQuery(final java.util.Map<String, Object> query) {
        final Iterable<Platform> platforms = (Iterable<Platform>)query.get("platforms");

        final Iterator<Platform> iterator = platforms.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    ShardStatus.class.getCanonicalName(), iterator.next().getTag()
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManySummonerDtoQuery(final java.util.Map<String, Object> query) {
        final Iterable<Number> summonerIds = (Iterable<Number>)query.get("ids");
        final Iterable<Number> accountIds = (Iterable<Number>)query.get("accountIds");
        final Iterable<String> summonerNames = (Iterable<String>)query.get("names");

        final Iterator<?> iterator = summonerIds != null ? summonerIds.iterator() : accountIds != null ? accountIds.iterator() : summonerNames.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    com.merakianalytics.orianna.types.dto.summoner.Summoner.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(),
                    summonerIds != null || accountIds != null ? ((Number)iterator.next()).longValue() : iterator.next()
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };

    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManySummonerPositionsDtoQuery(final java.util.Map<String, Object> query) {
        final Iterable<Number> ids = (Iterable<Number>)query.get("summonerIds");

        final Iterator<Number> iterator = ids.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    SummonerPositions.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), iterator.next().longValue()
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManySummonerQuery(final java.util.Map<String, Object> query) {
        final Iterable<Number> ids = (Iterable<Number>)query.get("ids");
        final Iterable<Number> accountIds = (Iterable<Number>)query.get("accountIds");
        final Iterable<String> names = (Iterable<String>)query.get("names");

        final Iterator<?> iterator;
        if(ids != null) {
            iterator = ids.iterator();
        } else if(accountIds != null) {
            iterator = accountIds.iterator();
        } else if(names != null) {
            iterator = names.iterator();
        } else {
            return null;
        }

        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    Summoner.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(),
                    ids != null || accountIds != null ? ((Number)iterator.next()).longValue() : iterator.next()
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManySummonerSpellDtoQuery(final java.util.Map<String, Object> query) {
        final Iterable<Number> ids = (Iterable<Number>)query.get("ids");
        final Iterable<String> names = (Iterable<String>)query.get("names");

        final Iterator<?> iterator = ids != null ? ids.iterator() : names.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    com.merakianalytics.orianna.types.dto.staticdata.SummonerSpell.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(),
                    (String)query.get("version"), (String)query.get("locale"),
                    ids != null ? ((Number)iterator.next()).intValue() : iterator.next(), (Set<String>)query.get("includedData")
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };

    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManySummonerSpellListDtoQuery(final java.util.Map<String, Object> query) {
        final Iterable<String> versions = (Iterable<String>)query.get("versions");

        final Iterator<String> iterator = versions.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    SummonerSpellList.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), iterator.next(), (String)query.get("locale"),
                    (Set<String>)query.get("includedData")
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManySummonerSpellQuery(final java.util.Map<String, Object> query) {
        final Iterable<Number> ids = (Iterable<Number>)query.get("ids");
        final Iterable<String> names = (Iterable<String>)query.get("names");

        final Iterator<?> iterator;
        if(ids != null) {
            iterator = ids.iterator();
        } else if(names != null) {
            iterator = names.iterator();
        } else {
            return null;
        }

        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    SummonerSpell.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), (String)query.get("version"),
                    (String)query.get("locale"), ids != null ? ((Number)iterator.next()).intValue() : iterator.next(), (Set<String>)query.get("includedData")
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyTimelineQuery(final java.util.Map<String, Object> query) {
        final Iterable<Number> matchIds = (Iterable<Number>)query.get("matchIds");

        final Iterator<Number> iterator = matchIds.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    Timeline.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), iterator.next().longValue()
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyTournamentMatchesDtoQuery(final java.util.Map<String, Object> query) {
        final Iterable<String> codes = (Iterable<String>)query.get("tournamentCodes");

        final Iterator<String> iterator = codes.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    com.merakianalytics.orianna.types.dto.match.TournamentMatches.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(),
                    iterator.next()
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyTournamentMatchesQuery(final java.util.Map<String, Object> query) {
        final Iterable<String> tournamentCodes = (Iterable<String>)query.get("tournamentCodes");

        final Iterator<String> iterator = tournamentCodes.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    TournamentMatches.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), iterator.next()
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyVerificationStringDtoQuery(final java.util.Map<String, Object> query) {
        final Iterable<Number> ids = (Iterable<Number>)query.get("summonerIds");

        final Iterator<Number> iterator = ids.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    com.merakianalytics.orianna.types.dto.thirdpartycode.VerificationString.class.getCanonicalName(),
                    ((Platform)query.get("platform")).getTag(), iterator.next().longValue()
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyVerificationStringQuery(final java.util.Map<String, Object> query) {
        final Iterable<Number> summonerIds = (Iterable<Number>)query.get("summonerIds");

        final Iterator<Number> iterator = summonerIds.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    VerificationString.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), iterator.next().longValue()
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static Iterator<Integer> forManyVersionsDtoQuery(final java.util.Map<String, Object> query) {
        final Iterable<Platform> platforms = (Iterable<Platform>)query.get("platforms");

        final Iterator<Platform> iterator = platforms.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return Arrays.hashCode(new Object[] {
                    com.merakianalytics.orianna.types.dto.staticdata.Versions.class.getCanonicalName(), iterator.next().getTag()
                });
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static int[] forMap(final Map map) {
        final com.merakianalytics.orianna.types.data.staticdata.Map data = map.getCoreData();
        if(data.getId() != 0 && data.getName() != null) {
            return new int[] {
                Arrays.hashCode(new Object[] {
                    Map.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getId()
                }),
                Arrays.hashCode(new Object[] {
                    Map.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getName()
                })
            };
        } else if(data.getId() != 0) {
            return new int[] {
                Arrays.hashCode(new Object[] {
                    Map.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getId()
                })
            };
        } else if(data.getName() != null) {
            return new int[] {
                Arrays.hashCode(new Object[] {
                    Map.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getName()
                })
            };
        } else {
            throw new IllegalArgumentException("Can't get key for Map without ID or name!");
        }
    }

    public static int forMapDataDto(final MapData maps) {
        return Arrays.hashCode(new Object[] {
            MapData.class.getCanonicalName(), maps.getPlatform(), maps.getVersion(), maps.getLocale()
        });
    }

    public static int forMapDataDtoQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            MapData.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), (String)query.get("version"), (String)query.get("locale")
        });
    }

    public static int[] forMapDetailsDto(final MapDetails map) {
        return new int[] {
            Arrays.hashCode(new Object[] {
                MapDetails.class.getCanonicalName(), map.getPlatform(), map.getVersion(), map.getLocale(), map.getMapId()
            }),
            Arrays.hashCode(new Object[] {
                MapDetails.class.getCanonicalName(), map.getPlatform(), map.getVersion(), map.getLocale(), map.getMapName()
            })
        };
    }

    public static int forMapDetailsDtoQuery(final java.util.Map<String, Object> query) {
        final Number id = (Number)query.get("id");
        final String name = (String)query.get("name");
        return Arrays.hashCode(new Object[] {
            MapDetails.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), (String)query.get("version"), (String)query.get("locale"),
            id == null ? name : id.intValue()
        });
    }

    public static int forMapQuery(final java.util.Map<String, Object> query) {
        final Number id = (Number)query.get("id");
        final String name = (String)query.get("name");
        return Arrays.hashCode(new Object[] {
            Map.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), (String)query.get("version"), (String)query.get("locale"),
            id == null ? name : id.intValue()
        });
    }

    public static int forMaps(final Maps maps) {
        final com.merakianalytics.orianna.types.data.staticdata.Maps data = maps.getCoreData();
        return Arrays.hashCode(new Object[] {
            Maps.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale()
        });
    }

    public static int forMapsQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            Maps.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), (String)query.get("version"), (String)query.get("locale")
        });
    }

    public static int forMasteries(final Masteries masteries) {
        final com.merakianalytics.orianna.types.data.staticdata.Masteries data = masteries.getCoreData();
        return Arrays.hashCode(new Object[] {
            Masteries.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getIncludedData()
        });
    }

    @SuppressWarnings("unchecked")
    public static int forMasteriesQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            Masteries.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), (String)query.get("version"), (String)query.get("locale"),
            (Set<String>)query.get("includedData")
        });
    }

    public static int[] forMastery(final Mastery mastery) {
        final com.merakianalytics.orianna.types.data.staticdata.Mastery data = mastery.getCoreData();
        if(data.getId() != 0 && data.getName() != null) {
            return new int[] {
                Arrays.hashCode(new Object[] {
                    Mastery.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getId(), data.getIncludedData()
                }),
                Arrays.hashCode(new Object[] {
                    Mastery.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getName(), data.getIncludedData()
                })
            };
        } else if(data.getId() != 0) {
            return new int[] {
                Arrays.hashCode(new Object[] {
                    Mastery.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getId(), data.getIncludedData()
                })
            };
        } else if(data.getName() != null) {
            return new int[] {
                Arrays.hashCode(new Object[] {
                    Mastery.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getName(), data.getIncludedData()
                })
            };
        } else {
            throw new IllegalArgumentException("Can't get key for Mastery without ID or name!");
        }
    }

    public static int[] forMasteryDto(final com.merakianalytics.orianna.types.dto.staticdata.Mastery mastery) {
        return new int[] {
            Arrays.hashCode(new Object[] {
                com.merakianalytics.orianna.types.dto.staticdata.Mastery.class.getCanonicalName(), mastery.getPlatform(), mastery.getVersion(),
                mastery.getLocale(), mastery.getId(), mastery.getIncludedData()
            }),
            Arrays.hashCode(new Object[] {
                com.merakianalytics.orianna.types.dto.staticdata.Mastery.class.getCanonicalName(), mastery.getPlatform(), mastery.getVersion(),
                mastery.getLocale(), mastery.getName(), mastery.getIncludedData()
            })
        };
    }

    @SuppressWarnings("unchecked")
    public static int forMasteryDtoQuery(final java.util.Map<String, Object> query) {
        final Number id = (Number)query.get("id");
        final String name = (String)query.get("name");
        return Arrays.hashCode(new Object[] {
            com.merakianalytics.orianna.types.dto.staticdata.Mastery.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(),
            (String)query.get("version"), (String)query.get("locale"),
            id == null ? name : id.intValue(), (Set<String>)query.get("includedData")
        });
    }

    public static int forMasteryListDto(final MasteryList masteries) {
        return Arrays.hashCode(new Object[] {
            MasteryList.class.getCanonicalName(), masteries.getPlatform(), masteries.getVersion(), masteries.getLocale(), masteries.getIncludedData()
        });
    }

    @SuppressWarnings("unchecked")
    public static int forMasteryListDtoQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            MasteryList.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), (String)query.get("version"), (String)query.get("locale"),
            (Set<String>)query.get("includedData")
        });
    }

    @SuppressWarnings("unchecked")
    public static int forMasteryQuery(final java.util.Map<String, Object> query) {
        final Number id = (Number)query.get("id");
        final String name = (String)query.get("name");
        return Arrays.hashCode(new Object[] {
            Mastery.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), (String)query.get("version"), (String)query.get("locale"),
            id == null ? name : id.intValue(), (Set<String>)query.get("includedData")
        });
    }

    public static int forMatch(final Match match) {
        final com.merakianalytics.orianna.types.data.match.Match data = match.getCoreData();
        return Arrays.hashCode(new Object[] {
            Match.class.getCanonicalName(), data.getPlatform(), data.getId()
        });
    }

    public static int forMatchDto(final com.merakianalytics.orianna.types.dto.match.Match match) {
        return Arrays.hashCode(new Object[] {
            com.merakianalytics.orianna.types.dto.match.Match.class.getCanonicalName(), match.getPlatformId(), match.getGameId()
        });
    }

    public static int forMatchDtoQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            com.merakianalytics.orianna.types.dto.match.Match.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(),
            ((Number)query.get("matchId")).longValue()
        });
    }

    public static int forMatchQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            Match.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), ((Number)query.get("matchId")).longValue()
        });
    }

    public static int forMatchTimelineDto(final MatchTimeline timeline) {
        return Arrays.hashCode(new Object[] {
            MatchTimeline.class.getCanonicalName(), timeline.getPlatform(), timeline.getMatchId()
        });
    }

    public static int forMatchTimelineDtoQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            MatchTimeline.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), ((Number)query.get("matchId")).longValue()
        });
    }

    public static int forProfileIcon(final ProfileIcon icon) {
        final com.merakianalytics.orianna.types.data.staticdata.ProfileIcon data = icon.getCoreData();
        return Arrays.hashCode(new Object[] {
            ProfileIcon.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getId()
        });
    }

    public static int forProfileIconDataDto(final ProfileIconData profileIcons) {
        return Arrays.hashCode(new Object[] {
            ProfileIconData.class.getCanonicalName(), profileIcons.getPlatform(), profileIcons.getVersion(), profileIcons.getLocale()
        });
    }

    public static int forProfileIconDataDtoQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            ProfileIconData.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), (String)query.get("version"), (String)query.get("locale")
        });
    }

    public static int forProfileIconDetailsDto(final ProfileIconDetails icon) {
        return Arrays.hashCode(new Object[] {
            ProfileIconDetails.class.getCanonicalName(), icon.getPlatform(), icon.getVersion(), icon.getLocale(), icon.getId()
        });
    }

    public static int forProfileIconDetailsDtoQuery(final java.util.Map<String, Object> query) {
        final Number id = (Number)query.get("id");
        return Arrays.hashCode(new Object[] {
            ProfileIconDetails.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), (String)query.get("version"), (String)query.get("locale"),
            id.longValue()
        });
    }

    public static int forProfileIconQuery(final java.util.Map<String, Object> query) {
        final Number id = (Number)query.get("id");
        return Arrays.hashCode(new Object[] {
            ProfileIcon.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), (String)query.get("version"), (String)query.get("locale"),
            id.intValue()
        });
    }

    public static int forProfileIcons(final ProfileIcons profileIcons) {
        final com.merakianalytics.orianna.types.data.staticdata.ProfileIcons data = profileIcons.getCoreData();
        return Arrays.hashCode(new Object[] {
            ProfileIcons.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale()
        });
    }

    public static int forProfileIconsQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            ProfileIcons.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), (String)query.get("version"), (String)query.get("locale")
        });
    }

    public static int forRealm(final Realm realm) {
        final com.merakianalytics.orianna.types.data.staticdata.Realm data = realm.getCoreData();
        return Arrays.hashCode(new Object[] {
            Realm.class.getCanonicalName(), data.getPlatform()
        });
    }

    public static int forRealmDto(final com.merakianalytics.orianna.types.dto.staticdata.Realm realm) {
        return Arrays.hashCode(new Object[] {
            com.merakianalytics.orianna.types.dto.staticdata.Realm.class.getCanonicalName(), realm.getPlatform()
        });
    }

    public static int forRealmDtoQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            com.merakianalytics.orianna.types.dto.staticdata.Realm.class.getCanonicalName(), ((Platform)query.get("platform")).getTag()
        });
    }

    public static int forRealmQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            Realm.class.getCanonicalName(), ((Platform)query.get("platform")).getTag()
        });
    }

    public static int[] forReforgedRune(final ReforgedRune rune) {
        final com.merakianalytics.orianna.types.data.staticdata.ReforgedRune data = rune.getCoreData();
        if(data.getId() != 0 && data.getName() != null && data.getKey() != null) {
            return new int[] {
                Arrays.hashCode(new Object[] {
                    ReforgedRune.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getId()
                }),
                Arrays.hashCode(new Object[] {
                    ReforgedRune.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getName()
                }),
                Arrays.hashCode(new Object[] {
                    ReforgedRune.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getKey()
                })
            };
        } else if(data.getId() != 0 && data.getName() != null) {
            return new int[] {
                Arrays.hashCode(new Object[] {
                    ReforgedRune.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getId()
                }),
                Arrays.hashCode(new Object[] {
                    ReforgedRune.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getName()
                })
            };
        } else if(data.getId() != 0 && data.getKey() != null) {
            return new int[] {
                Arrays.hashCode(new Object[] {
                    ReforgedRune.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getId()
                }),
                Arrays.hashCode(new Object[] {
                    ReforgedRune.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getKey()
                })
            };
        } else if(data.getName() != null && data.getKey() != null) {
            return new int[] {
                Arrays.hashCode(new Object[] {
                    ReforgedRune.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getName()
                }),
                Arrays.hashCode(new Object[] {
                    ReforgedRune.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getKey()
                })
            };
        } else if(data.getId() != 0) {
            return new int[] {
                Arrays.hashCode(new Object[] {
                    ReforgedRune.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getId()
                })
            };
        } else if(data.getName() != null) {
            return new int[] {
                Arrays.hashCode(new Object[] {
                    ReforgedRune.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getName()
                })
            };
        } else if(data.getKey() != null) {
            return new int[] {
                Arrays.hashCode(new Object[] {
                    ReforgedRune.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getKey()
                })
            };
        } else {
            throw new IllegalArgumentException("Can't get key for ReforgedRune without ID, name, or key!");
        }
    }

    public static int[] forReforgedRuneDto(final com.merakianalytics.orianna.types.dto.staticdata.ReforgedRune rune) {
        return new int[] {
            Arrays.hashCode(new Object[] {
                com.merakianalytics.orianna.types.dto.staticdata.ReforgedRune.class.getCanonicalName(), rune.getPlatform(), rune.getVersion(), rune.getLocale(),
                rune.getId()
            }),
            Arrays.hashCode(new Object[] {
                com.merakianalytics.orianna.types.dto.staticdata.ReforgedRune.class.getCanonicalName(), rune.getPlatform(), rune.getVersion(), rune.getLocale(),
                rune.getName()
            }),
            Arrays.hashCode(new Object[] {
                com.merakianalytics.orianna.types.dto.staticdata.ReforgedRune.class.getCanonicalName(), rune.getPlatform(), rune.getVersion(), rune.getLocale(),
                rune.getKey()
            })
        };
    }

    public static int forReforgedRuneDtoQuery(final java.util.Map<String, Object> query) {
        final Number id = (Number)query.get("id");
        final String name = (String)query.get("name");
        final String key = (String)query.get("key");
        return Arrays.hashCode(new Object[] {
            com.merakianalytics.orianna.types.dto.staticdata.ReforgedRune.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(),
            (String)query.get("version"), (String)query.get("locale"),
            id == null ? name == null ? key : name : id.intValue()
        });
    }

    public static int forReforgedRuneQuery(final java.util.Map<String, Object> query) {
        final Number id = (Number)query.get("id");
        final String name = (String)query.get("name");
        final String key = (String)query.get("key");
        return Arrays.hashCode(new Object[] {
            ReforgedRune.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), (String)query.get("version"), (String)query.get("locale"),
            id == null ? name == null ? key : name : id.intValue()
        });
    }

    public static int forReforgedRunes(final ReforgedRunes runes) {
        final com.merakianalytics.orianna.types.data.staticdata.ReforgedRunes data = runes.getCoreData();
        return Arrays.hashCode(new Object[] {
            ReforgedRunes.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale()
        });
    }

    public static int forReforgedRunesQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            ReforgedRunes.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), (String)query.get("version"), (String)query.get("locale")
        });
    }

    public static int forReforgedRuneTreeDto(final ReforgedRuneTree runes) {
        return Arrays.hashCode(new Object[] {
            ReforgedRuneTree.class.getCanonicalName(), runes.getPlatform(), runes.getVersion(), runes.getLocale()
        });
    }

    public static int forReforgedRuneTreeDtoQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            ReforgedRuneTree.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), (String)query.get("version"), (String)query.get("locale")
        });
    }

    public static int[] forRune(final Rune rune) {
        final com.merakianalytics.orianna.types.data.staticdata.Rune data = rune.getCoreData();
        if(data.getId() != 0 && data.getName() != null) {
            return new int[] {
                Arrays.hashCode(new Object[] {
                    Rune.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getId(), data.getIncludedData()
                }),
                Arrays.hashCode(new Object[] {
                    Rune.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getName(), data.getIncludedData()
                })
            };
        } else if(data.getId() != 0) {
            return new int[] {
                Arrays.hashCode(new Object[] {
                    Rune.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getId(), data.getIncludedData()
                })
            };
        } else if(data.getName() != null) {
            return new int[] {
                Arrays.hashCode(new Object[] {
                    Rune.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getName(), data.getIncludedData()
                })
            };
        } else {
            throw new IllegalArgumentException("Can't get key for Item without ID or name!");
        }
    }

    public static int[] forRuneDto(final com.merakianalytics.orianna.types.dto.staticdata.Rune rune) {
        return new int[] {
            Arrays.hashCode(new Object[] {
                com.merakianalytics.orianna.types.dto.staticdata.Rune.class.getCanonicalName(), rune.getPlatform(), rune.getVersion(), rune.getLocale(),
                rune.getId(), rune.getIncludedData()
            }),
            Arrays.hashCode(new Object[] {
                com.merakianalytics.orianna.types.dto.staticdata.Rune.class.getCanonicalName(), rune.getPlatform(), rune.getVersion(), rune.getLocale(),
                rune.getName(), rune.getIncludedData()
            })
        };
    }

    @SuppressWarnings("unchecked")
    public static int forRuneDtoQuery(final java.util.Map<String, Object> query) {
        final Number id = (Number)query.get("id");
        final String name = (String)query.get("name");
        return Arrays.hashCode(new Object[] {
            com.merakianalytics.orianna.types.dto.staticdata.Rune.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(),
            (String)query.get("version"), (String)query.get("locale"),
            id == null ? name : id.intValue(), (Set<String>)query.get("includedData")
        });
    }

    public static int forRuneListDto(final RuneList runes) {
        return Arrays.hashCode(new Object[] {
            RuneList.class.getCanonicalName(), runes.getPlatform(), runes.getVersion(), runes.getLocale(), runes.getIncludedData()
        });
    }

    @SuppressWarnings("unchecked")
    public static int forRuneListDtoQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            RuneList.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), (String)query.get("version"), (String)query.get("locale"),
            (Set<String>)query.get("includedData")
        });
    }

    @SuppressWarnings("unchecked")
    public static int forRuneQuery(final java.util.Map<String, Object> query) {
        final Number id = (Number)query.get("id");
        final String name = (String)query.get("name");
        return Arrays.hashCode(new Object[] {
            Rune.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), (String)query.get("version"), (String)query.get("locale"),
            id == null ? name : id.intValue(), (Set<String>)query.get("includedData")
        });
    }

    public static int forRunes(final Runes runes) {
        final com.merakianalytics.orianna.types.data.staticdata.Runes data = runes.getCoreData();
        return Arrays.hashCode(new Object[] {
            Runes.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getIncludedData()
        });
    }

    @SuppressWarnings("unchecked")
    public static int forRunesQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            Runes.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), (String)query.get("version"), (String)query.get("locale"),
            (Set<String>)query.get("includedData")
        });
    }

    public static int forShardStatus(final ShardStatus status) {
        final com.merakianalytics.orianna.types.data.status.ShardStatus data = status.getCoreData();
        return Arrays.hashCode(new Object[] {
            ShardStatus.class.getCanonicalName(), data.getPlatform()
        });
    }

    public static int forShardStatusDto(final com.merakianalytics.orianna.types.dto.status.ShardStatus status) {
        return Arrays.hashCode(new Object[] {
            com.merakianalytics.orianna.types.dto.status.ShardStatus.class.getCanonicalName(), status.getPlatform()
        });
    }

    public static int forShardStatusDtoQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            com.merakianalytics.orianna.types.dto.status.ShardStatus.class.getCanonicalName(), ((Platform)query.get("platform")).getTag()
        });
    }

    public static int forShardStatusQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            ShardStatus.class.getCanonicalName(), ((Platform)query.get("platform")).getTag()
        });
    }

    public static int[] forSummoner(final Summoner summoner) {
        final com.merakianalytics.orianna.types.data.summoner.Summoner data = summoner.getCoreData();
        if(data.getId() != 0L && data.getAccountId() != 0L && data.getName() != null) {
            return new int[] {
                Arrays.hashCode(new Object[] {
                    Summoner.class.getCanonicalName(), data.getPlatform(), data.getId()
                }),
                Arrays.hashCode(new Object[] {
                    Summoner.class.getCanonicalName(), data.getPlatform(), data.getAccountId()
                }),
                Arrays.hashCode(new Object[] {
                    Summoner.class.getCanonicalName(), data.getPlatform(), data.getName()
                })
            };
        } else if(data.getId() != 0L && data.getAccountId() != 0L) {
            return new int[] {
                Arrays.hashCode(new Object[] {
                    Summoner.class.getCanonicalName(), data.getPlatform(), data.getId()
                }),
                Arrays.hashCode(new Object[] {
                    Summoner.class.getCanonicalName(), data.getPlatform(), data.getAccountId()
                }),
            };
        } else if(data.getId() != 0L && data.getName() != null) {
            return new int[] {
                Arrays.hashCode(new Object[] {
                    Summoner.class.getCanonicalName(), data.getPlatform(), data.getId()
                }),
                Arrays.hashCode(new Object[] {
                    Summoner.class.getCanonicalName(), data.getPlatform(), data.getName()
                })
            };
        } else if(data.getAccountId() != 0L && data.getName() != null) {
            return new int[] {
                Arrays.hashCode(new Object[] {
                    Summoner.class.getCanonicalName(), data.getPlatform(), data.getAccountId()
                }),
                Arrays.hashCode(new Object[] {
                    Summoner.class.getCanonicalName(), data.getPlatform(), data.getName()
                })
            };
        } else if(data.getId() != 0L) {
            return new int[] {
                Arrays.hashCode(new Object[] {
                    Summoner.class.getCanonicalName(), data.getPlatform(), data.getId()
                })
            };
        } else if(data.getAccountId() != 0L) {
            return new int[] {
                Arrays.hashCode(new Object[] {
                    Summoner.class.getCanonicalName(), data.getPlatform(), data.getAccountId()
                })
            };
        } else if(data.getName() != null) {
            return new int[] {
                Arrays.hashCode(new Object[] {
                    Summoner.class.getCanonicalName(), data.getPlatform(), data.getName()
                })
            };
        } else {
            throw new IllegalArgumentException("Can't get key for Summoner without ID, account ID, or name!");
        }
    }

    public static int[] forSummonerDto(final com.merakianalytics.orianna.types.dto.summoner.Summoner summoner) {
        return new int[] {
            Arrays.hashCode(new Object[] {
                com.merakianalytics.orianna.types.dto.summoner.Summoner.class.getCanonicalName(), summoner.getPlatform(), summoner.getId()
            }),
            Arrays.hashCode(new Object[] {
                com.merakianalytics.orianna.types.dto.summoner.Summoner.class.getCanonicalName(), summoner.getPlatform(), summoner.getAccountId()
            }),
            Arrays.hashCode(new Object[] {
                com.merakianalytics.orianna.types.dto.summoner.Summoner.class.getCanonicalName(), summoner.getPlatform(), summoner.getName()
            })
        };
    }

    public static int forSummonerDtoQuery(final java.util.Map<String, Object> query) {
        final Number id = (Number)query.get("id");
        final Number accountId = (Number)query.get("accountId");
        final String name = (String)query.get("name");
        return Arrays.hashCode(new Object[] {
            com.merakianalytics.orianna.types.dto.summoner.Summoner.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(),
            id == null ? accountId == null ? name : accountId.longValue() : id.longValue()
        });
    }

    public static int forSummonerPositionsDto(final SummonerPositions positions) {
        return Arrays.hashCode(new Object[] {
            SummonerPositions.class.getCanonicalName(), positions.getPlatform(), positions.getSummonerId()
        });
    }

    public static int forSummonerPositionsDtoQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            SummonerPositions.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), ((Number)query.get("summonerId")).longValue()
        });
    }

    public static int forSummonerQuery(final java.util.Map<String, Object> query) {
        final Number id = (Number)query.get("id");
        final Number accountId = (Number)query.get("accountId");
        final String name = (String)query.get("name");
        return Arrays.hashCode(new Object[] {
            Summoner.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(),
            id == null ? accountId == null ? name : accountId.longValue() : id.longValue()
        });
    }

    public static int[] forSummonerSpell(final SummonerSpell summonerSpell) {
        final com.merakianalytics.orianna.types.data.staticdata.SummonerSpell data = summonerSpell.getCoreData();
        if(data.getId() != 0 && data.getName() != null) {
            return new int[] {
                Arrays.hashCode(new Object[] {
                    SummonerSpell.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getId(), data.getIncludedData()
                }),
                Arrays.hashCode(new Object[] {
                    SummonerSpell.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getName(), data.getIncludedData()
                })
            };
        } else if(data.getId() != 0) {
            return new int[] {
                Arrays.hashCode(new Object[] {
                    SummonerSpell.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getId(), data.getIncludedData()
                })
            };
        } else if(data.getName() != null) {
            return new int[] {
                Arrays.hashCode(new Object[] {
                    SummonerSpell.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getName(), data.getIncludedData()
                })
            };
        } else {
            throw new IllegalArgumentException("Can't get key for Item without ID or name!");
        }
    }

    public static int[] forSummonerSpellDto(final com.merakianalytics.orianna.types.dto.staticdata.SummonerSpell summonerSpell) {
        return new int[] {
            Arrays.hashCode(new Object[] {
                com.merakianalytics.orianna.types.dto.staticdata.SummonerSpell.class.getCanonicalName(), summonerSpell.getPlatform(),
                summonerSpell.getVersion(), summonerSpell.getLocale(), summonerSpell.getId(), summonerSpell.getIncludedData()
            }),
            Arrays.hashCode(new Object[] {
                com.merakianalytics.orianna.types.dto.staticdata.SummonerSpell.class.getCanonicalName(), summonerSpell.getPlatform(),
                summonerSpell.getVersion(), summonerSpell.getLocale(), summonerSpell.getName(), summonerSpell.getIncludedData()
            })
        };
    }

    @SuppressWarnings("unchecked")
    public static int forSummonerSpellDtoQuery(final java.util.Map<String, Object> query) {
        final Number id = (Number)query.get("id");
        final String name = (String)query.get("name");
        return Arrays.hashCode(new Object[] {
            com.merakianalytics.orianna.types.dto.staticdata.SummonerSpell.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(),
            (String)query.get("version"), (String)query.get("locale"),
            id == null ? name : id.intValue(), (Set<String>)query.get("includedData")
        });
    }

    public static int forSummonerSpellListDto(final SummonerSpellList spells) {
        return Arrays.hashCode(new Object[] {
            SummonerSpellList.class.getCanonicalName(), spells.getPlatform(), spells.getVersion(), spells.getLocale(), spells.getIncludedData()
        });
    }

    @SuppressWarnings("unchecked")
    public static int forSummonerSpellListDtoQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            SummonerSpellList.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), (String)query.get("version"), (String)query.get("locale"),
            (Set<String>)query.get("includedData")
        });
    }

    @SuppressWarnings("unchecked")
    public static int forSummonerSpellQuery(final java.util.Map<String, Object> query) {
        final Number id = (Number)query.get("id");
        final String name = (String)query.get("name");
        return Arrays.hashCode(new Object[] {
            SummonerSpell.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), (String)query.get("version"), (String)query.get("locale"),
            id == null ? name : id.intValue(), (Set<String>)query.get("includedData")
        });
    }

    public static int forSummonerSpells(final SummonerSpells spells) {
        final com.merakianalytics.orianna.types.data.staticdata.SummonerSpells data = spells.getCoreData();
        return Arrays.hashCode(new Object[] {
            SummonerSpells.class.getCanonicalName(), data.getPlatform(), data.getVersion(), data.getLocale(), data.getIncludedData()
        });
    }

    @SuppressWarnings("unchecked")
    public static int forSummonerSpellsQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            SummonerSpells.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), (String)query.get("version"), (String)query.get("locale"),
            (Set<String>)query.get("includedData")
        });
    }

    public static int forTimeline(final Timeline timeline) {
        final com.merakianalytics.orianna.types.data.match.Timeline data = timeline.getCoreData();
        return Arrays.hashCode(new Object[] {
            Timeline.class.getCanonicalName(), data.getPlatform(), data.getId()
        });
    }

    public static int forTimelineQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            Timeline.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), ((Number)query.get("matchId")).longValue()
        });
    }

    public static int forTournamentMatches(final TournamentMatches matches) {
        final com.merakianalytics.orianna.types.data.match.TournamentMatches data = matches.getCoreData();
        return Arrays.hashCode(new Object[] {
            TournamentMatches.class.getCanonicalName(), data.getPlatform(), data.getTournamentCode()
        });
    }

    public static int forTournamentMatchesDto(final com.merakianalytics.orianna.types.dto.match.TournamentMatches matches) {
        return Arrays.hashCode(new Object[] {
            com.merakianalytics.orianna.types.dto.match.TournamentMatches.class.getCanonicalName(), matches.getPlatform(), matches.getTournamentCode()
        });
    }

    public static int forTournamentMatchesDtoQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            com.merakianalytics.orianna.types.dto.match.TournamentMatches.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(),
            (String)query.get("tournamentCode")
        });
    }

    public static int forTournamentMatchesQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            TournamentMatches.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), (String)query.get("tournamentCode")
        });
    }

    public static int forVerificationString(final VerificationString string) {
        final com.merakianalytics.orianna.types.data.thirdpartycode.VerificationString data = string.getCoreData();
        return Arrays.hashCode(new Object[] {
            VerificationString.class.getCanonicalName(), data.getPlatform(), data.getSummonerId()
        });
    }

    public static int forVerificationStringDto(final com.merakianalytics.orianna.types.dto.thirdpartycode.VerificationString string) {
        return Arrays.hashCode(new Object[] {
            com.merakianalytics.orianna.types.dto.thirdpartycode.VerificationString.class.getCanonicalName(), string.getPlatform(), string.getSummonerId()
        });
    }

    public static int forVerificationStringDtoQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            com.merakianalytics.orianna.types.dto.thirdpartycode.VerificationString.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(),
            ((Number)query.get("summonerId")).longValue()
        });
    }

    public static int forVerificationStringQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            VerificationString.class.getCanonicalName(), ((Platform)query.get("platform")).getTag(), ((Number)query.get("summonerId")).longValue()
        });
    }

    public static int forVersions(final Versions versions) {
        final com.merakianalytics.orianna.types.data.staticdata.Versions data = versions.getCoreData();
        return Arrays.hashCode(new Object[] {
            Versions.class.getCanonicalName(), data.getPlatform()
        });
    }

    public static int forVersionsDto(final com.merakianalytics.orianna.types.dto.staticdata.Versions versions) {
        return Arrays.hashCode(new Object[] {
            com.merakianalytics.orianna.types.dto.staticdata.Versions.class.getCanonicalName(), versions.getPlatform()
        });
    }

    public static int forVersionsDtoQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            com.merakianalytics.orianna.types.dto.staticdata.Versions.class.getCanonicalName(), ((Platform)query.get("platform")).getTag()
        });
    }

    public static int forVersionsQuery(final java.util.Map<String, Object> query) {
        return Arrays.hashCode(new Object[] {
            Versions.class.getCanonicalName(), ((Platform)query.get("platform")).getTag()
        });
    }
}
