FROM alpine:3.19.4
RUN apk update && apk add --no-cache tzdata   \ 
    mariadb-client \
    postgresql13-client \
    net-tools bash\
    vim git build-base ca-certificates \
    wget curl jq nushell bind-tools\
    go ruby openjdk21 python3 nodejs \

COPY ./init /opt/init
RUN cat /opt/init/vfox-install.sh | bash
RUN echo 'eval "$(vfox activate bash)"' >> ~/.bashrc
RUN vfox add nodejs && 
#20240925


ENV TZ=Asia/Tokyo

CMD ["/bin/bash"]


# docker build . -t clftool
# docker run --tty --detach --privileged --name clftool --volume=./data:/opt/data clftool
# docker exec -it clftool /bin/bash