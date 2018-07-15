package com.merakianalytics.orianna.types.core.staticdata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.GameMode;
import com.merakianalytics.orianna.types.common.Platform;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.GhostObject;
import com.merakianalytics.orianna.types.core.searchable.Searchable;
import com.merakianalytics.orianna.types.core.searchable.SearchableList;
import com.merakianalytics.orianna.types.core.searchable.SearchableLists;

public class SummonerSpell extends GhostObject<com.merakianalytics.orianna.types.data.staticdata.SummonerSpell> {
    public static class Builder {
        private Integer id;
        private Set<String> includedData;
        private String name, version, locale;
        private Platform platform;

        private Builder(final int id) {
            this.id = id;
        }

        private Builder(final String name) {
            this.name = name;
        }

        public SummonerSpell get() {
            if(name == null && id == null) {
                throw new IllegalStateException("Must set an ID or name for the SummonerSpell!");
            }

            if(platform == null) {
                platform = Orianna.getSettings().getDefaultPlatform();
                if(platform == null) {
                    throw new IllegalStateException(
                        "No platform/region was set! Must either set a default platform/region with Orianna.setDefaultPlatform or Orianna.setDefaultRegion, or include a platform/region with the request!");
                }
            }

            if(version == null) {
                version = Orianna.getSettings().getCurrentVersion(platform);
            }

            if(locale == null) {
                locale = Orianna.getSettings().getDefaultLocale();
                locale = locale == null ? platform.getDefaultLocale() : locale;
            }

            if(includedData == null) {
                includedData = ImmutableSet.of("all");
            }

            final ImmutableMap.Builder<String, Object> builder = ImmutableMap.<String, Object> builder().put("platform", platform).put("version", version)
                .put("locale", locale).put("includedData", includedData);

            if(id != null) {
                builder.put("id", id);
            } else {
                builder.put("name", name);
            }

            return Orianna.getSettings().getPipeline().get(SummonerSpell.class, builder.build());
        }

        public Builder withIncludedData(final Iterable<String> includedData) {
            this.includedData = Sets.newHashSet(includedData);
            return this;
        }

        public Builder withIncludedData(final String... includedData) {
            this.includedData = Sets.newHashSet(includedData);
            return this;
        }

        public Builder withLocale(final String locale) {
            this.locale = locale;
            return this;
        }

        public Builder withPlatform(final Platform platform) {
            this.platform = platform;
            return this;
        }

        public Builder withRegion(final Region region) {
            platform = region.getPlatform();
            return this;
        }

        public Builder withVersion(final String version) {
            this.version = version;
            return this;
        }
    }

    private static final long serialVersionUID = -4080746989103816773L;
    public static final String SUMMONER_SPELL_LOAD_GROUP = "summoner-spell";

    public static Builder named(final String name) {
        return new Builder(name);
    }

    public static Builder withId(final int id) {
        return new Builder(id);
    }

    private final Supplier<List<Double>> cooldowns = Suppliers.memoize(new Supplier<List<Double>>() {
        @Override
        public List<Double> get() {
            load(SUMMONER_SPELL_LOAD_GROUP);
            if(coreData.getCooldowns() == null) {
                return null;
            }
            return Collections.unmodifiableList(coreData.getCooldowns());
        }
    });

    private final Supplier<List<Integer>> costs = Suppliers.memoize(new Supplier<List<Integer>>() {
        @Override
        public List<Integer> get() {
            load(SUMMONER_SPELL_LOAD_GROUP);
            if(coreData.getCosts() == null) {
                return null;
            }
            return Collections.unmodifiableList(coreData.getCosts());
        }
    });

    private final Supplier<List<List<Double>>> effects = Suppliers.memoize(new Supplier<List<List<Double>>>() {
        @Override
        public List<List<Double>> get() {
            load(SUMMONER_SPELL_LOAD_GROUP);
            if(coreData.getEffects() == null) {
                return null;
            }
            final List<List<Double>> views = new ArrayList<>(coreData.getEffects().size());
            for(final List<Double> effect : coreData.getEffects()) {
                views.add(Collections.unmodifiableList(effect));
            }
            return Collections.unmodifiableList(views);
        }
    });

    private final Supplier<Image> image = Suppliers.memoize(new Supplier<Image>() {
        @Override
        public Image get() {
            load(SUMMONER_SPELL_LOAD_GROUP);
            if(coreData.getImage() == null) {
                return null;
            }
            return new Image(coreData.getImage());
        }
    });

    private final Supplier<Set<String>> includedData = Suppliers.memoize(new Supplier<Set<String>>() {
        @Override
        public Set<String> get() {
            if(coreData.getIncludedData() == null) {
                return null;
            }
            return Collections.unmodifiableSet(coreData.getIncludedData());
        }
    });

    private final Supplier<List<String>> levelUpEffects = Suppliers.memoize(new Supplier<List<String>>() {
        @Override
        public List<String> get() {
            load(SUMMONER_SPELL_LOAD_GROUP);
            if(coreData.getLevelUpEffects() == null) {
                return null;
            }
            return Collections.unmodifiableList(coreData.getLevelUpEffects());
        }
    });

    private final Supplier<List<String>> levelUpKeywords = Suppliers.memoize(new Supplier<List<String>>() {
        @Override
        public List<String> get() {
            load(SUMMONER_SPELL_LOAD_GROUP);
            if(coreData.getLevelUpKeywords() == null) {
                return null;
            }
            return Collections.unmodifiableList(coreData.getLevelUpKeywords());
        }
    });

    private final Supplier<Set<GameMode>> modes = Suppliers.memoize(new Supplier<Set<GameMode>>() {
        @Override
        public Set<GameMode> get() {
            load(SUMMONER_SPELL_LOAD_GROUP);
            if(coreData.getModes() == null) {
                return null;
            }
            final Set<GameMode> modes = new HashSet<>();
            for(final String mode : coreData.getModes()) {
                modes.add(GameMode.valueOf(mode));
            }
            return Collections.unmodifiableSet(modes);
        }
    });

    private final Supplier<List<Integer>> ranges = Suppliers.memoize(new Supplier<List<Integer>>() {
        @Override
        public List<Integer> get() {
            load(SUMMONER_SPELL_LOAD_GROUP);
            if(coreData.getRanges() == null) {
                return null;
            }
            return Collections.unmodifiableList(coreData.getRanges());
        }
    });

    private final Supplier<SearchableList<SpellVariables>> variables = Suppliers.memoize(new Supplier<SearchableList<SpellVariables>>() {
        @Override
        public SearchableList<SpellVariables> get() {
            load(SUMMONER_SPELL_LOAD_GROUP);
            if(coreData.getVariables() == null) {
                return null;
            }
            final List<SpellVariables> variables = new ArrayList<>(coreData.getVariables().size());
            for(final com.merakianalytics.orianna.types.data.staticdata.SpellVariables vars : coreData.getVariables()) {
                variables.add(new SpellVariables(vars));
            }
            return SearchableLists.unmodifiableFrom(variables);
        }
    });

    public SummonerSpell(final com.merakianalytics.orianna.types.data.staticdata.SummonerSpell coreData) {
        super(coreData, 1);
    }

    @Override
    public boolean exists() {
        if(coreData.getDescription() == null) {
            load(SUMMONER_SPELL_LOAD_GROUP);
        }
        return coreData.getDescription() != null;
    }

    public List<Double> getCooldowns() {
        return cooldowns.get();
    }

    public List<Integer> getCosts() {
        return costs.get();
    }

    public String getDescription() {
        load(SUMMONER_SPELL_LOAD_GROUP);
        return coreData.getDescription();
    }

    public List<List<Double>> getEffects() {
        return effects.get();
    }

    @Searchable(int.class)
    public int getId() {
        if(coreData.getId() == 0) {
            load(SUMMONER_SPELL_LOAD_GROUP);
        }
        return coreData.getId();
    }

    public Image getImage() {
        return image.get();
    }

    public Set<String> getIncludedData() {
        return includedData.get();
    }

    @Searchable(String.class)
    public String getKey() {
        if(coreData.getKey() == null) {
            load(SUMMONER_SPELL_LOAD_GROUP);
        }
        return coreData.getKey();
    }

    public List<String> getLevelUpEffects() {
        return levelUpEffects.get();
    }

    public List<String> getLevelUpKeywords() {
        return levelUpKeywords.get();
    }

    @Override
    protected List<String> getLoadGroups() {
        return Arrays.asList(new String[] {
            SUMMONER_SPELL_LOAD_GROUP
        });
    }

    public String getLocale() {
        return coreData.getLocale();
    }

    public int getMaxRank() {
        if(coreData.getMaxRank() == 0) {
            load(SUMMONER_SPELL_LOAD_GROUP);
        }
        return coreData.getMaxRank();
    }

    public Set<GameMode> getModes() {
        return modes.get();
    }

    @Searchable(String.class)
    public String getName() {
        if(coreData.getName() == null) {
            load(SUMMONER_SPELL_LOAD_GROUP);
        }
        return coreData.getName();
    }

    public Platform getPlatform() {
        return Platform.withTag(coreData.getPlatform());
    }

    public List<Integer> getRanges() {
        return ranges.get();
    }

    public Region getRegion() {
        return Platform.withTag(coreData.getPlatform()).getRegion();
    }

    public String getResource() {
        if(coreData.getResource() == null) {
            load(SUMMONER_SPELL_LOAD_GROUP);
        }
        return coreData.getResource();
    }

    public String getResourceDescription() {
        if(coreData.getResourceDescription() == null) {
            load(SUMMONER_SPELL_LOAD_GROUP);
        }
        return coreData.getResourceDescription();
    }

    public String getSanitizedDescription() {
        if(coreData.getSanitizedDescription() == null) {
            load(SUMMONER_SPELL_LOAD_GROUP);
        }
        return coreData.getSanitizedDescription();
    }

    public String getSanitizedTooltip() {
        if(coreData.getSanitizedTooltip() == null) {
            load(SUMMONER_SPELL_LOAD_GROUP);
        }
        return coreData.getSanitizedTooltip();
    }

    public int getSummonerLevelRequirement() {
        if(coreData.getSummonerLevelRequirement() == 0) {
            load(SUMMONER_SPELL_LOAD_GROUP);
        }
        return coreData.getSummonerLevelRequirement();
    }

    public String getTooltip() {
        if(coreData.getTooltip() == null) {
            load(SUMMONER_SPELL_LOAD_GROUP);
        }
        return coreData.getTooltip();
    }

    public SearchableList<SpellVariables> getVariables() {
        return variables.get();
    }

    public String getVersion() {
        return coreData.getVersion();
    }

    @Override
    protected void loadCoreData(final String group) {
        ImmutableMap.Builder<String, Object> builder;
        switch(group) {
            case SUMMONER_SPELL_LOAD_GROUP:
                builder = ImmutableMap.builder();
                if(coreData.getId() != 0) {
                    builder.put("id", coreData.getId());
                }
                if(coreData.getName() != null) {
                    builder.put("name", coreData.getName());
                }
                if(coreData.getPlatform() != null) {
                    builder.put("platform", Platform.withTag(coreData.getPlatform()));
                }
                if(coreData.getVersion() != null) {
                    builder.put("version", coreData.getVersion());
                }
                if(coreData.getLocale() != null) {
                    builder.put("locale", coreData.getLocale());
                }
                if(coreData.getIncludedData() != null) {
                    builder.put("includedData", coreData.getIncludedData());
                }
                final com.merakianalytics.orianna.types.data.staticdata.SummonerSpell data =
                    Orianna.getSettings().getPipeline().get(com.merakianalytics.orianna.types.data.staticdata.SummonerSpell.class, builder.build());
                if(data != null) {
                    coreData = data;
                }
                break;
            default:
                break;
        }
    }
}
