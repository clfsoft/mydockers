FROM alpine:3.19.4
RUN apk update && apk add --no-cache tzdata   \ 
    mariadb-client \
    postgresql13-client \
    net-tools bash\
    vim git build-base ca-certificates \
    wget curl jq nushell\
    go ruby openjdk21 python3 nodejs

    #to merget to up 
RUN apk add --no-cache bind-tools

ENV TZ=Asia/Tokyo

ENTRYPOINT ["/bin/bash"]
