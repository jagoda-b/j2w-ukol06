[#ftl]
[@c.page]
    <div class="detail">

        <form class="delete" method="post" action="/" >
            <input type="hidden" name="id" value="${id}">
            <input type="submit" value="Smazat">
        </form>

        <div class="vizitka">
            <div class="jmeno">${vizitka.jmeno}</div>
            <div class="firma">${vizitka.firma}</div>
            <div class="udaje">
                <div class="adresa">
                    [#if vizitka.ulice??]
                        <div>${vizitka.ulice}</div>
                    [/#if]
                    [#if vizitka.psc??]
                        <div>${vizitka.psc}</div>
                    [/#if]
                </div>
                <div class="kontakty">
                    [#if vizitka.email??]
                        <div><i class="las la-at"></i> <a href="mailto:${vizitka.email}"> <span>${vizitka.email}</span></a></div>
                    [/#if]
                    [#if vizitka.telefon??]
                        <div><i class="las la-phone-alt"></i> <a href="tel:${vizitka.telefon}"><span>${vizitka.telefon}</span></a></div>
                    [/#if]
                    [#if vizitka.web??]
                        <div><i class="las la-globe"></i> <span>${vizitka.web}</span></div>
                    [/#if]
                </div>
            </div>
        </div>

        <div class="mapa">
            [#if vizitka.celaAdresa??]
                <iframe style="border:none" src="https://frame.mapy.cz/?q=${vizitka.celaAdresa?url("UTF-8")}" width="100%"
                        height="100%" frameborder="0"></iframe>
            [/#if]
        </div>

        [@c.back /]
    </div>
[/@c.page]
