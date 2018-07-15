package com.merakianalytics.orianna.types.core.staticdata;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Platform;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.GhostObject;
import com.merakianalytics.orianna.types.core.searchable.Searchable;
import com.merakianalytics.orianna.types.core.searchable.SearchableList;
import com.merakianalytics.orianna.types.core.searchable.SearchableLists;

public class Item extends GhostObject<com.merakianalytics.orianna.types.data.staticdata.Item> {
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

        public Item get() {
            if(name == null && id == null) {
                throw new IllegalStateException("Must set an ID or name for the Item!");
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

            return Orianna.getSettings().getPipeline().get(Item.class, builder.build());
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

    public static final String ITEM_LOAD_GROUP = "item";
    private static final long serialVersionUID = 307765113960787815L;

    public static Builder named(final String name) {
        return new Builder(name);
    }

    public static Builder withId(final int id) {
        return new Builder(id);
    }

    private final Supplier<SearchableList<Item>> buildsFrom = Suppliers.memoize(new Supplier<SearchableList<Item>>() {
        @Override
        public SearchableList<Item> get() {
            load(ITEM_LOAD_GROUP);
            if(coreData.getBuildsFrom() == null) {
                return null;
            }
            return SearchableLists.unmodifiableFrom(Items.withIds(coreData.getBuildsFrom()).withPlatform(Platform.withTag(coreData.getPlatform()))
                .withVersion(coreData.getVersion()).withLocale(coreData.getLocale()).get());
        }
    });

    private final Supplier<SearchableList<Item>> buildsInto = Suppliers.memoize(new Supplier<SearchableList<Item>>() {
        @Override
        public SearchableList<Item> get() {
            load(ITEM_LOAD_GROUP);
            if(coreData.getBuildsInto() == null) {
                return null;
            }
            return SearchableLists.unmodifiableFrom(Items.withIds(coreData.getBuildsInto()).withPlatform(Platform.withTag(coreData.getPlatform()))
                .withVersion(coreData.getVersion()).withLocale(coreData.getLocale()).get());
        }
    });

    private final Supplier<Map<String, String>> effects = Suppliers.memoize(new Supplier<Map<String, String>>() {
        @Override
        public Map<String, String> get() {
            load(ITEM_LOAD_GROUP);
            if(coreData.getEffects() == null) {
                return null;
            }
            return Collections.unmodifiableMap(coreData.getEffects());
        }
    });

    private final Supplier<Image> image = Suppliers.memoize(new Supplier<Image>() {
        @Override
        public Image get() {
            load(ITEM_LOAD_GROUP);
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

    private final Supplier<Set<String>> keywords = Suppliers.memoize(new Supplier<Set<String>>() {
        @Override
        public Set<String> get() {
            load(ITEM_LOAD_GROUP);
            if(coreData.getKeywords() == null) {
                return null;
            }
            return Collections.unmodifiableSet(coreData.getKeywords());
        }
    });

    private final Supplier<Set<com.merakianalytics.orianna.types.common.Map>> maps = Suppliers.memoize(
        new Supplier<Set<com.merakianalytics.orianna.types.common.Map>>() {
            @Override
            public Set<com.merakianalytics.orianna.types.common.Map> get() {
                load(ITEM_LOAD_GROUP);
                if(coreData.getMaps() == null) {
                    return null;
                }
                final Set<com.merakianalytics.orianna.types.common.Map> maps = new HashSet<>();
                for(final Integer id : coreData.getMaps()) {
                    maps.add(com.merakianalytics.orianna.types.common.Map.withId(id));
                }
                return Collections.unmodifiableSet(maps);
            }
        });

    private final Supplier<Champion> requiredChampion = Suppliers.memoize(new Supplier<Champion>() {
        @Override
        public Champion get() {
            load(ITEM_LOAD_GROUP);
            if(coreData.getRequiredChampionKey() == null) {
                return null;
            }
            return Champion.withKey(coreData.getRequiredChampionKey()).withPlatform(Platform.withTag(coreData.getPlatform())).withVersion(coreData.getVersion())
                .withLocale(coreData.getLocale()).get();
        }
    });

    private final Supplier<ItemStats> stats = Suppliers.memoize(new Supplier<ItemStats>() {
        @Override
        public ItemStats get() {
            load(ITEM_LOAD_GROUP);
            if(coreData.getStats() == null) {
                return null;
            }
            return new ItemStats(coreData.getStats());
        }
    });

    private final Supplier<List<String>> tags = Suppliers.memoize(new Supplier<List<String>>() {
        @Override
        public List<String> get() {
            load(ITEM_LOAD_GROUP);
            if(coreData.getTags() == null) {
                return null;
            }
            return Collections.unmodifiableList(coreData.getTags());
        }
    });

    public Item(final com.merakianalytics.orianna.types.data.staticdata.Item coreData) {
        super(coreData, 1);
    }

    @Override
    public boolean exists() {
        if(coreData.getDescription() == null) {
            load(ITEM_LOAD_GROUP);
        }
        return coreData.getDescription() != null;
    }

    public int getBasePrice() {
        if(coreData.getBasePrice() == 0) {
            load(ITEM_LOAD_GROUP);
        }
        return coreData.getBasePrice();
    }

    public SearchableList<Item> getBuildsFrom() {
        return buildsFrom.get();
    }

    public SearchableList<Item> getBuildsInto() {
        return buildsInto.get();
    }

    public String getDescription() {
        if(coreData.getDescription() == null) {
            load(ITEM_LOAD_GROUP);
        }
        return coreData.getDescription();
    }

    public Map<String, String> getEffects() {
        return effects.get();
    }

    public String getGroup() {
        if(coreData.getGroup() == null) {
            load(ITEM_LOAD_GROUP);
        }
        return coreData.getGroup();
    }

    @Searchable(int.class)
    public int getId() {
        if(coreData.getId() == 0) {
            load(ITEM_LOAD_GROUP);
        }
        return coreData.getId();
    }

    public Image getImage() {
        return image.get();
    }

    public Set<String> getIncludedData() {
        return includedData.get();
    }

    public Set<String> getKeywords() {
        return keywords.get();
    }

    @Override
    protected List<String> getLoadGroups() {
        return Arrays.asList(new String[] {
            ITEM_LOAD_GROUP
        });
    }

    public String getLocale() {
        return coreData.getLocale();
    }

    public Set<com.merakianalytics.orianna.types.common.Map> getMaps() {
        return maps.get();
    }

    public int getMaxStacks() {
        load(ITEM_LOAD_GROUP);
        return coreData.getMaxStacks();
    }

    @Searchable(String.class)
    public String getName() {
        if(coreData.getName() == null) {
            load(ITEM_LOAD_GROUP);
        }
        return coreData.getName();
    }

    public String getPlaintext() {
        if(coreData.getPlaintext() == null) {
            load(ITEM_LOAD_GROUP);
        }
        return coreData.getPlaintext();
    }

    public Platform getPlatform() {
        return Platform.withTag(coreData.getPlatform());
    }

    public Region getRegion() {
        return Platform.withTag(coreData.getPlatform()).getRegion();
    }

    public Champion getRequiredChampion() {
        return requiredChampion.get();
    }

    public String getSanitizedDescription() {
        if(coreData.getSanitizedDescription() == null) {
            load(ITEM_LOAD_GROUP);
        }
        return coreData.getSanitizedDescription();
    }

    public int getSellPrice() {
        if(coreData.getSellPrice() == 0) {
            load(ITEM_LOAD_GROUP);
        }
        return coreData.getSellPrice();
    }

    public int getSource() {
        if(coreData.getSource() == 0) {
            load(ITEM_LOAD_GROUP);
        }
        return coreData.getSource();
    }

    public ItemStats getStats() {
        return stats.get();
    }

    public List<String> getTags() {
        return tags.get();
    }

    public int getTier() {
        if(coreData.getTier() == 0) {
            load(ITEM_LOAD_GROUP);
        }
        return coreData.getTier();
    }

    public int getTotalPrice() {
        if(coreData.getTotalPrice() == 0) {
            load(ITEM_LOAD_GROUP);
        }
        return coreData.getTotalPrice();
    }

    public String getVersion() {
        return coreData.getVersion();
    }

    public boolean isConsumed() {
        if(!coreData.isConsumed()) {
            load(ITEM_LOAD_GROUP);
        }
        return coreData.isConsumed();
    }

    public boolean isConsumedWhenFull() {
        if(!coreData.isConsumedWhenFull()) {
            load(ITEM_LOAD_GROUP);
        }
        return coreData.isConsumedWhenFull();
    }

    public boolean isHiddenFromAll() {
        if(!coreData.isHiddenFromAll()) {
            load(ITEM_LOAD_GROUP);
        }
        return coreData.isHiddenFromAll();
    }

    public boolean isInStore() {
        if(!coreData.isInStore()) {
            load(ITEM_LOAD_GROUP);
        }
        return coreData.isInStore();
    }

    public boolean isPurchasable() {
        if(!coreData.isPurchasable()) {
            load(ITEM_LOAD_GROUP);
        }
        return coreData.isPurchasable();
    }

    @Override
    protected void loadCoreData(final String group) {
        ImmutableMap.Builder<String, Object> builder;
        switch(group) {
            case ITEM_LOAD_GROUP:
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

                final com.merakianalytics.orianna.types.data.staticdata.Item data =
                    Orianna.getSettings().getPipeline().get(com.merakianalytics.orianna.types.data.staticdata.Item.class, builder.build());
                if(data != null) {
                    coreData = data;
                }
                break;
            default:
                break;
        }
    }
}
