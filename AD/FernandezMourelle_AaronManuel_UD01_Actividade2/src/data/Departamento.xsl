<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <html>
            <xsl:apply-templates/>
        </html>
    </xsl:template>
    <xsl:template match="DepartmentList">
        <head>
            <title>LISTADO DE DEPARTAMENTOS</title>
        </head>
        <body>
            <h1>LISTA DE DEPARTAMENTOS</h1>
            <table border="1">
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Localización</th>
                </tr>
                <xsl:apply-templates select="Department"/>
            </table>
        </body>
    </xsl:template>

    <xsl:template match="Department">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>

    <xsl:template match="id|name|location">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
</xsl:stylesheet>