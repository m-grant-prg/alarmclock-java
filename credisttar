project_root=$(dirname $0)
mkdir -p $project_root/distribution
tar -cvpz --format=posix -f $project_root/distribution/AlarmClock$(git describe --always 1>/dev/null 2>/dev/null && git describe --always | tr -d '\n' || echo 'Pre-Release' | tr -d '\n').tar.gz --directory=$project_root/dist --exclude=README.TXT .

