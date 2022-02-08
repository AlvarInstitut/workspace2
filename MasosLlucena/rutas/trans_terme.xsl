<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/">
    <gpx>
        <trk>
            <trkseg>
                 <xsl:for-each select="//trkpt">
                  <trkpt>
                    <lat><xsl:value-of select="@lat"/></lat>
                    <lon><xsl:value-of select="@lon"/></lon>
                  </trkpt>
                </xsl:for-each>
            </trkseg>
        </trk>
    </gpx>
  </xsl:template>
</xsl:stylesheet>
