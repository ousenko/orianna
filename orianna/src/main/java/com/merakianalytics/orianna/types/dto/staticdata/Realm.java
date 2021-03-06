package com.merakianalytics.orianna.types.dto.staticdata;

import java.util.Map;

import com.merakianalytics.orianna.types.dto.DataObject;

public class Realm extends DataObject {
    private static final long serialVersionUID = 56986044820906047L;
    private String lg, dd, l, store, v, cdn, css, platform;
    private Map<String, String> n;
    private int profileiconmax;

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null) {
            return false;
        }
        if(getClass() != obj.getClass()) {
            return false;
        }
        final Realm other = (Realm)obj;
        if(cdn == null) {
            if(other.cdn != null) {
                return false;
            }
        } else if(!cdn.equals(other.cdn)) {
            return false;
        }
        if(css == null) {
            if(other.css != null) {
                return false;
            }
        } else if(!css.equals(other.css)) {
            return false;
        }
        if(dd == null) {
            if(other.dd != null) {
                return false;
            }
        } else if(!dd.equals(other.dd)) {
            return false;
        }
        if(l == null) {
            if(other.l != null) {
                return false;
            }
        } else if(!l.equals(other.l)) {
            return false;
        }
        if(lg == null) {
            if(other.lg != null) {
                return false;
            }
        } else if(!lg.equals(other.lg)) {
            return false;
        }
        if(n == null) {
            if(other.n != null) {
                return false;
            }
        } else if(!n.equals(other.n)) {
            return false;
        }
        if(platform == null) {
            if(other.platform != null) {
                return false;
            }
        } else if(!platform.equals(other.platform)) {
            return false;
        }
        if(profileiconmax != other.profileiconmax) {
            return false;
        }
        if(store == null) {
            if(other.store != null) {
                return false;
            }
        } else if(!store.equals(other.store)) {
            return false;
        }
        if(v == null) {
            if(other.v != null) {
                return false;
            }
        } else if(!v.equals(other.v)) {
            return false;
        }
        return true;
    }

    /**
     * @return the cdn
     */
    public String getCdn() {
        return cdn;
    }

    /**
     * @return the css
     */
    public String getCss() {
        return css;
    }

    /**
     * @return the dd
     */
    public String getDd() {
        return dd;
    }

    /**
     * @return the l
     */
    public String getL() {
        return l;
    }

    /**
     * @return the lg
     */
    public String getLg() {
        return lg;
    }

    /**
     * @return the n
     */
    public Map<String, String> getN() {
        return n;
    }

    /**
     * @return the platform
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * @return the profileiconmax
     */
    public int getProfileiconmax() {
        return profileiconmax;
    }

    /**
     * @return the store
     */
    public String getStore() {
        return store;
    }

    /**
     * @return the v
     */
    public String getV() {
        return v;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (cdn == null ? 0 : cdn.hashCode());
        result = prime * result + (css == null ? 0 : css.hashCode());
        result = prime * result + (dd == null ? 0 : dd.hashCode());
        result = prime * result + (l == null ? 0 : l.hashCode());
        result = prime * result + (lg == null ? 0 : lg.hashCode());
        result = prime * result + (n == null ? 0 : n.hashCode());
        result = prime * result + (platform == null ? 0 : platform.hashCode());
        result = prime * result + profileiconmax;
        result = prime * result + (store == null ? 0 : store.hashCode());
        result = prime * result + (v == null ? 0 : v.hashCode());
        return result;
    }

    /**
     * @param cdn
     *        the cdn to set
     */
    public void setCdn(final String cdn) {
        this.cdn = cdn;
    }

    /**
     * @param css
     *        the css to set
     */
    public void setCss(final String css) {
        this.css = css;
    }

    /**
     * @param dd
     *        the dd to set
     */
    public void setDd(final String dd) {
        this.dd = dd;
    }

    /**
     * @param l
     *        the l to set
     */
    public void setL(final String l) {
        this.l = l;
    }

    /**
     * @param lg
     *        the lg to set
     */
    public void setLg(final String lg) {
        this.lg = lg;
    }

    /**
     * @param n
     *        the n to set
     */
    public void setN(final Map<String, String> n) {
        this.n = n;
    }

    /**
     * @param platform
     *        the platform to set
     */
    public void setPlatform(final String platform) {
        this.platform = platform;
    }

    /**
     * @param profileiconmax
     *        the profileiconmax to set
     */
    public void setProfileiconmax(final int profileiconmax) {
        this.profileiconmax = profileiconmax;
    }

    /**
     * @param store
     *        the store to set
     */
    public void setStore(final String store) {
        this.store = store;
    }

    /**
     * @param v
     *        the v to set
     */
    public void setV(final String v) {
        this.v = v;
    }
}
